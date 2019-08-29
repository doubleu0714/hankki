package io.hankki.auth.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@EqualsAndHashCode
@ToString
@Entity
public class HankkiUserEntity {
    @Id
    @Column(nullable = false, unique = true, length = 100)
    private String userId;

    @Column(nullable = false, length = 100)
    private String userPw;

    @Column(nullable = false, length = 100)
    private String userName;
}