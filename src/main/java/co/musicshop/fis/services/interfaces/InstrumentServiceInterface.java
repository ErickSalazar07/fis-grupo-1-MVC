package co.musicshop.fis.services.interfaces;

import co.musicshop.fis.models.Instrument;

import java.util.List;


public interface InstrumentServiceInterface {
    List<Instrument> findAllInstruments();
    Instrument saveInstrument(Instrument instrument);
    void deleteInstrument(Long id);
    Instrument updateInstrument(Instrument instrument);
    Instrument findInstrumentById(Long id);
}
