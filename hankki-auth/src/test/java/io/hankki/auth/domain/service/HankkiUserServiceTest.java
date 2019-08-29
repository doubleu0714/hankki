package io.hankki.auth.domain.service;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import io.hankki.auth.domain.dto.HankkiUserDTO;
import io.hankki.auth.domain.entity.HankkiUserEntity;
import io.hankki.auth.domain.repository.HankkiUserRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HankkiUserServiceTest {
    @Autowired
    private HankkiUserService userService;

    @MockBean
    private HankkiUserRepository userRepository;

    @Test
    public void 아이디로_조회_테스트() {
        // given
        String userId = "test1";
        String userPw = "$2a$10$LtYl70lIJP42VvVUEa6yeet7i4bsYiGOWNgFVzjLsiEay1wC7pBOe";
        String userName = "test1";
        BDDMockito.given(userRepository.findById(userId)).willReturn(Optional.of(HankkiUserEntity.builder().userId(userId).userPw(userPw).userName(userName).build()));

        // when
        HankkiUserDTO dto = userService.getUserById(userId);
        
        // then
        assertThat(dto.getUserId(), is(userId));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 잘못된_아이디로_조회_테스트() {
        // given
        String userId = "";

        // when
        userService.getUserById(userId);
    }

    @Test(expected = NoSuchElementException.class)
    public void 없는_아이디로_조회_테스트() {
        // given
        String userId = "USER06";

        // when
        userService.getUserById(userId);
    }

    @Test
    public void 토큰발행_테스트() {
        // given
        // given
        String userId = "test1";
        String userPw = "1111";
        String userName = "test1";
        BDDMockito.given(userRepository.findById(userId)).willReturn(Optional.of(HankkiUserEntity.builder().userId(userId).userPw("$2a$10$bo9THbrltKUoSBFiuQuTOuTobUhXyUELmnUENqKp2AwRRuO2JvqoG").userName(userName).build()));

        // when
        String token = userService.signIn(userId, userPw);

        // then
        assertTrue(StringUtils.hasText(token));
        System.out.println("token: " + token);
    }
}