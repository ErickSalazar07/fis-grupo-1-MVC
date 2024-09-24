package co.musicshop.fis.services.interfaces;

import co.musicshop.fis.models.Song;

import java.util.List;

public interface SongServiceInterface {
    List<Song> findAllSongs();
    Song saveSong(Song song);
    void deleteSong(Long id);
    Song updateSong(Song song);
    Song findSongById(Long id);
}
