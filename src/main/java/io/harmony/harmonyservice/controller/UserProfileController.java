package io.harmony.harmonyservice.controller;

import io.harmony.harmonyservice.dto.UserProfileDto;
import io.harmony.harmonyservice.service.UserProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
public class UserProfileController {

    private final UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GetMapping
    public ResponseEntity<UserProfileDto> getProfile() {
        UserProfileDto userProfile = userProfileService.getProfile();
        return ResponseEntity.ok(userProfile);
    }

    @PostMapping("/nickname")
    public ResponseEntity<Void> updateNickname(@RequestBody UserProfileDto userProfileDto) {
        userProfileService.updateNickname(userProfileDto.getNickname());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout() {
        userProfileService.logout();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteAccount() {
        userProfileService.deleteAccount();
        return ResponseEntity.ok().build();
    }
}
