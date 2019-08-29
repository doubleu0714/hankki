package io.hankki.auth.domain.repository;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.hankki.auth.domain.entity.HankkiUserEntity;
import io.hankki.auth.domain.entity.QHankkiUserEntity;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HankkiUserRepositoryTest {
    @Autowired
    private HankkiUserRepository hankkiUserRepository;

    @Before
    public void setup() {
        
    }

    @Test
    public void 저장_테스트() {
        // given
        String userId = "TEST_ID";
        String userPw = "TEST_PW";
        String userName = "TEST_NAME";
        HankkiUserEntity entity = HankkiUserEntity.builder()
                                                  .userId(userId)
                                                  .userPw(userPw)
                                                  .userName(userName)
                                                  .build();

        // when
        hankkiUserRepository.save(entity);
        
        // then
        assertThat(hankkiUserRepository.findById(userId).get(), is(entity));
    }

    @Test
    public void predicate_조회_테스트() {
        // given
        String userId = "TEST_ID";
        String userPw = "TEST_PW";
        String userName = "TEST_NAME";
        HankkiUserEntity entity = HankkiUserEntity.builder()
                                                  .userId(userId)
                                                  .userPw(userPw)
                                                  .userName(userName)
                                                  .build();
                                                  
        // when
        hankkiUserRepository.save(entity);
                                                  
        // then
        assertThat(hankkiUserRepository.findOne(QHankkiUserEntity.hankkiUserEntity.userName.eq(userName)).get(), is(entity));
    }
}