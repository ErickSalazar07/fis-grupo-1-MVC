package co.musicshop.fis.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSongDto {
    private String title;
    private String artist;
    private String genre;
    private Integer year;
    private String album;
    private String albumCover;
    private String duration;
}
