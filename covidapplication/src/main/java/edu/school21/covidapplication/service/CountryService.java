package edu.school21.covidapplication.service;

import com.google.gson.Gson;
import edu.school21.covidapplication.entity.CoronaData;
import edu.school21.covidapplication.entity.Country;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class CountryService {

    public Country findByName(String name) throws IOException {
        String url = "https://corona-api.com/countries";
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
        CoronaData coronaData = gson.fromJson(response.toString(), CoronaData.class);
        for (Country country : coronaData.getData())
            if (country.getName().equalsIgnoreCase(name))
                return country;
        return null;
    }

}
