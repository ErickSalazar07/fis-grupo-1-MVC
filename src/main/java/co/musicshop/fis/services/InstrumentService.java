package co.musicshop.fis.services;

import co.musicshop.fis.models.Instrument;
import co.musicshop.fis.repositories.InstrumentRepository;
import co.musicshop.fis.repositories.SongRepository;
import co.musicshop.fis.services.interfaces.InstrumentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrumentService implements InstrumentServiceInterface {
    private final InstrumentRepository instrumentRepository;

    @Autowired
    public InstrumentService(InstrumentRepository instrumentRepository) {
        this.instrumentRepository = instrumentRepository;
    }

    @Override
    public List<Instrument> findAllInstruments(){ return instrumentRepository.findAll();}

    @Override
    public Instrument saveInstrument(Instrument instrument) {
        return instrumentRepository.save(instrument);
    }

    @Override
    public void deleteInstrument(Long id) {
        instrumentRepository.deleteById(id);
    }

    @Override
    public Instrument updateInstrument(Instrument instrument) {
        return instrumentRepository.save(instrument);
    }

    @Override
    public Instrument findInstrumentById(Long id) {
        return instrumentRepository.findById(id).orElse(null);
    }
}
