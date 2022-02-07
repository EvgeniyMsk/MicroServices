package edu.school21.aggregatorapplication.controller;

import edu.school21.aggregatorapplication.entity.AggregatedInformation;
import edu.school21.aggregatorapplication.service.AggregatedInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;

@Controller
public class InformationController {
    private final AggregatedInformationService aggregatedInformationService;

    @Autowired
    public InformationController(AggregatedInformationService aggregatedInformationService) {
        this.aggregatedInformationService = aggregatedInformationService;
    }

    @GetMapping("/information-management/countries/{countryName}")
    public String index(@PathVariable("countryName") String countryName, Model model) throws IOException {
        model.addAttribute("aggregatedinformation", aggregatedInformationService.getInfoByCountryName(countryName));
        return "info";
    }
}
