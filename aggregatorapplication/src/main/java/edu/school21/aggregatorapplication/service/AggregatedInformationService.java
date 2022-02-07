package edu.school21.aggregatorapplication.service;

import com.google.gson.Gson;
import edu.school21.aggregatorapplication.entity.AggregatedInformation;
import edu.school21.aggregatorapplication.entity.Country;
import edu.school21.aggregatorapplication.entity.Covid;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class AggregatedInformationService {

    public AggregatedInformation getInfoByCountryName(String countryName) throws IOException {
        String covidServiceURL =    "http://localhost/covid-management/countries/";
        String countriesServiceURL ="http://localhost/countries-management/countries/";

        String countriesURL = countriesServiceURL + countryName;
        String covidURL = covidServiceURL + countryName;
        Country country;
        Covid covid;

        Gson gson = new Gson();
        try {
            country = gson.fromJson(getDatafromURL(countriesURL), Country.class);
        } catch (Exception e) {
            country = null;
        }
        try {
            covid = gson.fromJson(getDatafromURL(covidURL), Covid.class);
        } catch (Exception e) {
            covid = null;
        }
        return new AggregatedInformation(country, covid);
    }

    private String getDatafromURL(String url) throws IOException {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }
}
