package edu.school21.countriesapplication.service;

import com.google.gson.Gson;
import edu.school21.countriesapplication.entity.Country;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;

@Service
public class CountryService {


    public Country findByName(String name) throws IOException {
        String url = "https://restcountries.com/v3.1/lang/rus";
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
        Gson gson = new Gson();
        Country[] countries = gson.fromJson(response.toString(), Country[].class);
        for (Country country : countries)
            if (country.getName().getCommon().equalsIgnoreCase(name))
                return country;
            return null;
    }

}
