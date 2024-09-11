package io.harmony.harmonyservice.service;

import io.harmony.harmonyservice.domain.User;
import io.harmony.harmonyservice.dto.UserProfileDto;
import io.harmony.harmonyservice.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {

    private final UserRepository userRepository;

    public UserProfileService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserProfileDto getProfile() {
        // 로그인된 사용자의 정보를 가져오는 로직 추가 필요
        User user = userRepository.findByKakaoName("현재 로그인된 사용자 이름"); // 나중에 변경 필요
        return toDto(user);
    }

    public void updateNickname(String newNickname) {
        // 사용자 닉네임 업데이트 로직
        User user = userRepository.findByKakaoName("현재 로그인된 사용자 이름");
        user.setNickname(newNickname);
        userRepository.save(user);
    }

    public void logout() {
        // 로그아웃 로직 구현
    }

    public void deleteAccount() {
        // 계정 삭제 로직 구현
    }

    private UserProfileDto toDto(User user) {
        UserProfileDto dto = new UserProfileDto();
        dto.setKakaoName(user.getKakaoName());
        dto.setEmail(user.getEmail());
        dto.setNickname(user.getNickname());
        return dto;
    }
}
