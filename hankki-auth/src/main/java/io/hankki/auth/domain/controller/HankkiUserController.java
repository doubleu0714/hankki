package io.hankki.auth.domain.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.hankki.auth.domain.dto.HankkiUserDTO;
import io.hankki.auth.domain.service.HankkiUserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class HankkiUserController {
    @NonNull
    private HankkiUserService userService;

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody HankkiUserDTO userDTO) {
        System.out.println(userDTO);
        String token = userService.signIn(userDTO.getUserId(), userDTO.getUserPw());
        return ResponseEntity.ok(token);
    }

    @PostMapping("logout")
    public void logout() {
        
    }
}