package io.harmony.harmonyservice.dto;

public class UserProfileDto {

    private String kakaoName;
    private String email;
    private String nickname;

    // getter 및 setter 메서드
    public String getKakaoName() {
        return kakaoName;
    }

    public void setKakaoName(String kakaoName) {
        this.kakaoName = kakaoName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
