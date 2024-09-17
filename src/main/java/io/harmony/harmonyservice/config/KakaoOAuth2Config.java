package io.harmony.harmonyservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;

@Configuration
public class KakaoOAuth2Config {

    private static final String CLIENT_ID = "YOUR_KAKAO_CLIENT_ID";  // 카카오 클라이언트 ID를 입력하세요
    private static final String CLIENT_SECRET = "YOUR_KAKAO_CLIENT_SECRET"; // 카카오 클라이언트 시크릿 입력

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(this.kakaoClientRegistration());
    }

    private ClientRegistration kakaoClientRegistration() {
        return ClientRegistration.withRegistrationId("kakao")
                .clientId(CLIENT_ID)
                .clientSecret(CLIENT_SECRET)
                .authorizationUri("https://kauth.kakao.com/oauth/authorize")
                .tokenUri("https://kauth.kakao.com/oauth/token")
                .userInfoUri("https://kapi.kakao.com/v2/user/me")
                .clientName("Kakao")
                .build();
    }
}
