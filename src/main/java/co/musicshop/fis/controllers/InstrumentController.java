package co.musicshop.fis.controllers;

import co.musicshop.fis.dtos.CreateInstrumentDto;
import org.springframework.ui.Model;
import co.musicshop.fis.models.Instrument;
import co.musicshop.fis.services.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/instruments")
public class InstrumentController {
    private final InstrumentService instrumentService;

    @Autowired
    public InstrumentController(InstrumentService instrumentService) { this.instrumentService = instrumentService; }


    @GetMapping()
    public String allInstruments(Model model) {
        List<Instrument> instruments = instrumentService.findAllInstruments();
        model.addAttribute("instruments", instruments);
        return "instruments";
    }

    @GetMapping("/add")
    public String addInstrumentForm(Model model){
        model.addAttribute("createInstrumentDto", new CreateInstrumentDto());
        return "addInstrument";
    }

    @PostMapping("/add")
    public String addInstrument(@ModelAttribute("createInstrumentDto") CreateInstrumentDto createInstrumentDto, Model model) {
        Instrument instrument = new Instrument(
                createInstrumentDto.getName(),
                createInstrumentDto.getType(),
                createInstrumentDto.getBrand(),
                createInstrumentDto.getPrice(),
                createInstrumentDto.getPhoto()
        );

        model.addAttribute("instrument", instrumentService.saveInstrument(instrument));
        return "redirect:/instruments";
    }

    @GetMapping("/{instrumentId}/update")
    public String updateInstrumentForm(@PathVariable("instrumentId") long instrumentId, Model model){
        Instrument instrument = instrumentService.findInstrumentById(instrumentId);
        model.addAttribute("instrument", instrument);
        return "updateInstrument";
    }

    @PostMapping("/{instrumentId}/update")
    public String updateInstrument(@PathVariable("instrumentId") long instrumentId, @ModelAttribute("instrument") Instrument instrument){
        instrument.setId(instrumentId);
        instrumentService.updateInstrument(instrument);
        return "redirect:/instruments";
    }

    @GetMapping("/{instrumentId}/delete")
    public String deleteInstrument(@PathVariable("instrumentId") long instrumentId, Model model){
        instrumentService.deleteInstrument(instrumentId);
        return "redirect:/instruments";
    }
}
