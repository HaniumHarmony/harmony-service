package io.harmony.harmonyservice.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"kakao_id"})
})
public class User {
    /* -------------------------------------------- */
    /* -------------- Default Column -------------- */
    /* -------------------------------------------- */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "kakao_id", nullable = false)
    private int kakaoId;

    /* -------------------------------------------- */
    /* ------------ Information Column ------------ */
    /* -------------------------------------------- */
    @Column(name = "nickname", nullable = false, length = 50)
    private String nickname;

    @Column(name = "level", nullable = false, length = 10)
    private String level; // 이거 Enum으로 바꾸는게 좋을 듯

    /* -------------------------------------------- */
    /* -------------- Relation Column ------------- */
    /* -------------------------------------------- */
    // User가 KakaoAccount를 참조하는 일대일 관계 설정
    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
    @JoinColumn(name = "kakao_id", referencedColumnName = "kakao_id") // 동일한 key를 사용할 지에 따라 바꿀 수 있음
    private List<KakaoAccount> kakaoAccounts;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Music> musics;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Lesson> lessons;

    /* -------------------------------------------- */
    /* ----------------- Functions ---------------- */
    /* -------------------------------------------- */

    // 여기에 함수 관련 코드 작성

}