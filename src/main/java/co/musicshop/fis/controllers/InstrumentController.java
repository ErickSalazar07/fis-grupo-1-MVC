package co.musicshop.fis.controllers;

import co.musicshop.fis.services.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/instruments")
public class InstrumentController {
    private final InstrumentService instrumentService;

    @Autowired
    public InstrumentController(InstrumentService instrumentService) { this.instrumentService = instrumentService; }



}
