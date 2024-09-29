package co.musicshop.fis.services;

import co.musicshop.fis.dtos.CreateSongDto;
import co.musicshop.fis.models.Song;
import co.musicshop.fis.repositories.SongRepository;
import co.musicshop.fis.services.interfaces.SongServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements SongServiceInterface {

    private final SongRepository songRepository;

    @Autowired
    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<Song> findAllSongs() {
        return songRepository.findAll();
    }

    @Override
    public Song saveSong(Song song) {
        return songRepository.save(song);
    }

    @Override
    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }

    @Override
    public Song updateSong(Song song) {
        return songRepository.save(song);
    }

    @Override
    public Song findSongById(Long id) { return songRepository.findById(id).orElse(null); }

    //TODO: Implement
    private Song mapToSong(CreateSongDto songDto){
        return null;
    }

    //TODO: Implement
    private CreateSongDto mapToSongDto(Song song){
        return null;
    }
}
