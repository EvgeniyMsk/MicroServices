package edu.school21.countriesapplication.controller;

import edu.school21.countriesapplication.entity.Country;
import edu.school21.countriesapplication.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/countries-management/countries")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping("/{countryName}")
    public ResponseEntity<Country> findCountryByName(@PathVariable("countryName") String countryName) throws IOException {
        return new ResponseEntity<>(countryService.findByName(countryName), HttpStatus.OK);
    }
}
