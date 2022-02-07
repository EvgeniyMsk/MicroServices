package edu.school21.covidapplication.controller;

import edu.school21.covidapplication.entity.Country;
import edu.school21.covidapplication.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/covid-management/countries")
public class CountryController {
    private CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/{countryName}")
    public ResponseEntity<Country> findCountryByName(@PathVariable("countryName") String countryName) throws IOException {
        return new ResponseEntity<>(countryService.findByName(countryName), HttpStatus.OK);
    }
}