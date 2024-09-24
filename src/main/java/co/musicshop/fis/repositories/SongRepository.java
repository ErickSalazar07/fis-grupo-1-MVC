package co.musicshop.fis.repositories;

import co.musicshop.fis.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
