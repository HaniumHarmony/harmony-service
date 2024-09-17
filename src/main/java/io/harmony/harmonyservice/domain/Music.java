package io.harmony.harmonyservice.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "musics")
public class Music {

    /* -------------------------------------------- */
    /* -------------- Default Column -------------- */
    /* -------------------------------------------- */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /* -------------------------------------------- */
    /* ------------ Information Columns ----------- */
    /* -------------------------------------------- */
    @Column(name = "music_name", length = 50, nullable = false)
    private String musicName;

    @Column(name = "music_data", columnDefinition = "TEXT", nullable = false)
    private String musicData;

    @Column(name = "music_format", length = 50, nullable = false)
    private String musicFormat = "musicxml";  // Default value

    @Column(name = "music_save", nullable = false)
    private boolean musicSave;

    @Column(name = "music_list", length = 50)
    private String musicList;

    /* -------------------------------------------- */
    /* ------------- Foreign Key Column ----------- */
    /* -------------------------------------------- */
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    /* -------------------------------------------- */
    /* ----------------- Functions ---------------- */
    /* -------------------------------------------- */

    // 생성자: Music 객체를 생성할 때 사용할 수 있는 생성자
    public Music(String musicName, String musicData, String musicFormat, boolean musicSave, String musicList, User user) {
        this.musicName = musicName;
        this.musicData = musicData;
        this.musicFormat = musicFormat;
        this.musicSave = musicSave;
        this.musicList = musicList;
        this.user = user;
    }
}
