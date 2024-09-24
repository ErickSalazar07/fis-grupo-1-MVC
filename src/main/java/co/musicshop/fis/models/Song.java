package co.musicshop.fis.models;

import jakarta.persistence.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
@Table(name = "song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "song_id")
    private Long id;

    @NonNull
    private String title;

    @NonNull
    private String artist;

    @NonNull
    private String genre;

    @NonNull
    private Integer year;

    @NonNull
    private String album;

    @Column(name = "album_cover")
    @NonNull
    private String albumCover;

    @NonNull
    private String duration;
}
