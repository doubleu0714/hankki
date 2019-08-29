package io.hankki.auth.domain.service;

import java.util.NoSuchElementException;

import org.springframework.security.core.userdetails.UserDetailsService;

import io.hankki.auth.domain.dto.HankkiUserDTO;

public interface HankkiUserService extends UserDetailsService {
    /**
     * 사용자 아이디로 한끼 시스템 유저 단건을 조회하는 메소드
     * @param userId 사용자 아이디
     * @return {@link HankkiUserDTO} 한끼 시스템 유저
     * @throw {@link IllegalArgumentException} userId 가 null이거나 빈 문자열인 경우
     * @throw {@link NoSuchElementException} userId에 해당하는 시스템 유저가 없는 경우
     */
    HankkiUserDTO getUserById(String userId);
    
    /**
     * Sign in을 위한 메소드 
     * @param userId 사용자 아이디
     * @param userPw 사용자 비밀번호
     * @return {@link HankkiUserDTO} 한끼 시스템 유저
     * @throw {@link IllegalArgumentException} userId 또는 userPw 가 null이거나 빈 문자열인 경우
     */
    String signIn(String userId, String userPw);

    /**
     * Sign out을 위한 메소드
     * @param userDTO {@link HankkiUserDTO} 한끼 시스템 유저
     */
    void signOut(HankkiUserDTO userDTO);
}