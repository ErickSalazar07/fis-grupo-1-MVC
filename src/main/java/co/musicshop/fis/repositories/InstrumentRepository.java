package co.musicshop.fis.repositories;

import co.musicshop.fis.models.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrumentRepository extends JpaRepository<Instrument, Long> {
}
