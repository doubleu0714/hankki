package io.hankki.auth.domain.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import io.hankki.auth.domain.config.JwtTokenUtil;
import io.hankki.auth.domain.dto.HankkiUserDTO;
import io.hankki.auth.domain.repository.HankkiUserRepository;
import io.hankki.auth.domain.service.HankkiUserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class HankkiUserServiceImpl implements HankkiUserService {
    @NonNull
    private HankkiUserRepository hankkiUserRepository;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public HankkiUserDTO getUserById(String userId) {
        return Optional.ofNullable(userId) /* 사용자 아이디를 Optional로 생성 */
                       .filter(StringUtils::hasText) /* 사용자 아이디가 null이 아니고 빈 문자열이 아닌면 */
                       .map(hankkiUserRepository::findById) /* repository에서 findById인자 값으로 전달 해서 조회 */
                       .map(Optional::get) /* 조회된 결과(Optional<HankkiUserEntity>)의 get 메소드를 호출(결과 없으면 NoSuchElementException) */
                       .map(entity -> {
                           return HankkiUserDTO.builder()
                                               .userId(entity.getUserId())
                                               .userName(entity.getUserName())
                                               .userPw(entity.getUserPw())
                                               .build();
                       }) /* 조회 결과가 있다면 DTO 객체로 변환 */
                       .orElseThrow(IllegalArgumentException::new); /* chain이 연결 호출 되지 않으면 Exception 발생 */
    }

    @Override
    public String signIn(String userId, String userPw) {
        return Optional.ofNullable(userId)
                       .filter(StringUtils::hasText)
                       .map(this::getUserById)
                       .filter(dto -> passwordEncoder.matches(userPw, dto.getUserPw()))
                       .map(jwtTokenUtil::generateToken)
                       .orElse("");
    }

    @Override
    public void signOut(HankkiUserDTO userDTO) {
        
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        HankkiUserDTO dto = Optional.ofNullable(username)
                                    .filter(StringUtils::hasText)
                                    .map(this::getUserById)
                                    .orElseThrow(IllegalArgumentException::new);
        
		return new User(dto.getUserId(), dto.getUserPw(), null);
	}

}