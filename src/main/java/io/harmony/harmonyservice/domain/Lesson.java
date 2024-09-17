package io.harmony.harmonyservice.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "lessons")
public class Lesson {

    /* -------------------------------------------- */
    /* -------------- Default Column -------------- */
    /* -------------------------------------------- */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /* -------------------------------------------- */
    /* ------------- Foreign Key Column ----------- */
    /* -------------------------------------------- */
    // 악보 ID와 연결된 부분 (Music과의 관계 설정)
    @ManyToOne
    @JoinColumn(name = "music_id", referencedColumnName = "id", nullable = false)
    private Music music;

    // 사용자 ID와 연결된 부분 (User와의 관계 설정)
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    /* -------------------------------------------- */
    /* ------------ Information Columns ----------- */
    /* -------------------------------------------- */
    @Column(name = "score", nullable = false)
    private int score;

    @Column(name = "beat", nullable = false)
    private int beat;

    @Column(name = "pitch_accuracy", nullable = false)
    private int pitchAccuracy;

    @Column(name = "feedback", columnDefinition = "TEXT")
    private String feedback;

    @Column(name = "lesson_status", length = 50, nullable = false)
    private String lessonStatus;

    /* -------------------------------------------- */
    /* ----------------- Functions ---------------- */
    /* -------------------------------------------- */

    // 생성자
    public Lesson(Music music, User user, int score, int beat, int pitchAccuracy, String feedback, String lessonStatus) {
        this.music = music;
        this.user = user;
        this.score = score;
        this.beat = beat;
        this.pitchAccuracy = pitchAccuracy;
        this.feedback = feedback;
        this.lessonStatus = lessonStatus;
    }
}
