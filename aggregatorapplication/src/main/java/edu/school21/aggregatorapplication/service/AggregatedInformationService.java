package edu.school21.aggregatorapplication.service;

import edu.school21.aggregatorapplication.entity.AggregatedInformation;
import edu.school21.aggregatorapplication.entity.Country;
import edu.school21.aggregatorapplication.entity.Covid;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class AggregatedInformationService {
    private final RestTemplate template;

    public AggregatedInformationService(RestTemplate template) {
        this.template = template;
    }

    public AggregatedInformation getInfoByCountryName(String countryName) {
        String covidServiceURL =    "http://covid-management/covid-management/countries/";
        String countriesServiceURL ="http://countries-management/countries-management/countries/";

        String countriesURL = countriesServiceURL + countryName;
        String covidURL = covidServiceURL + countryName;
        Country country;
        Covid covid;
        try {
            country = template.getForEntity(countriesURL, Country.class).getBody();
        } catch (Exception e) {
            country = null;
        }
        try {
            covid = template.getForEntity(covidURL, Covid.class).getBody();
        } catch (Exception e) {
            covid = null;
        }
        return new AggregatedInformation(country, covid);
    }
}
