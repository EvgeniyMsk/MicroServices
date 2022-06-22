package edu.school21.aggregatorapplication.service;

import edu.school21.aggregatorapplication.entity.AggregatedInformation;
import edu.school21.aggregatorapplication.entity.Country;
import edu.school21.aggregatorapplication.entity.Covid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class AggregatedInformationService {
    @Autowired
    @LoadBalanced
    private final RestTemplate template;

    @Autowired
    private LoadBalancerClient loadBalancer;
    public AggregatedInformationService(RestTemplate template) {
        this.template = template;
    }

    public AggregatedInformation getInfoByCountryName(String countryName) {
        String covidServiceURL =    "http://covid-management/countries/";
        String countriesServiceURL ="http://countries-management/countries/";

        String countriesURL = countriesServiceURL + countryName;
        String covidURL = covidServiceURL + countryName;
        Country country;
        Covid covid;
        ServiceInstance instance = loadBalancer.choose("covid-management");
        System.out.println(instance.getHost());
        try {
            System.out.println(template.getUriTemplateHandler().expand(countriesURL).getHost());
            country = template.getForObject(countriesURL, Country.class);
        } catch (Exception e) {
            country = null;
        }
        try {
            covid = template.getForObject(covidURL, Covid.class);
        } catch (Exception e) {
            covid = null;
        }
        return new AggregatedInformation(country, covid);
    }
}
