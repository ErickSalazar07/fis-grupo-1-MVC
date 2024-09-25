package co.musicshop.fis.controllers;

import co.musicshop.fis.dtos.CreateInstrumentDto;
import org.springframework.ui.Model;
import co.musicshop.fis.models.Instrument;
import co.musicshop.fis.services.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/instruments")
public class InstrumentController {
    private final InstrumentService instrumentService;

    @Autowired
    public InstrumentController(InstrumentService instrumentService) { this.instrumentService = instrumentService; }


    @GetMapping
    public String allInstruments(Model model) {
        List<Instrument> instruments = instrumentService.findAllInstruments();
        model.addAttribute("instruments", instruments);
        return "instruments";
    }

    @GetMapping("/addInstrument")
    public String addInstrumentForm(Model model){
        model.addAttribute("createSongDto", new CreateInstrumentDto());
        return "addInstrument";
    }

    @GetMapping("/deleteInstrument")
    public String deleteInstrument(@ModelAttribute("createInstrumentDto") CreateInstrumentDto createInstrumentDto, Model model){
        model.addAttribute("instruments", createInstrumentDto);
        return "deleteInstrument";
    }

    @GetMapping("/updateInstrument")
    public String updateInstrumentForm(@ModelAttribute("createInstrumentDto") CreateInstrumentDto createInstrumentDto, Model model){
        model.addAttribute("instrument", createInstrumentDto);
        return "updateInstrument";
    }

    @PostMapping
    public String addInstrument(@ModelAttribute("createInstrumentDto") CreateInstrumentDto createInstrumentDto, Model model) {
        Instrument instrument = new Instrument(
                createInstrumentDto.getName(),
                createInstrumentDto.getType(),
                createInstrumentDto.getBrand(),
                createInstrumentDto.getPrice(),
                createInstrumentDto.getPhoto()
        );

        this.instrumentService.saveInstrument(instrument);
        model.addAttribute("instrument",instrument);
        return "redirect:/instruments";
    }
}
