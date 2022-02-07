package edu.school21.aggregatorapplication.entity;

import lombok.Data;

@Data
public class AggregatedInformation {
    private String name;
    private String capital;
    private String area;
    private int population;
    private String googleMaps;
    private int deaths;
    private int confirmed;
    private int recovered;
    private int critical;
    private float death_rate;
    private float recovery_rate;
    private int cases_per_million_population;

    public AggregatedInformation(Country country, Covid covid) {
        try {
            this.name = country.getName().getCommon();
            this.capital = country.getCapital()[0];
            this.area = country.getArea();
            this.population = country.getPopulation();
            this.googleMaps = country.getMaps().getGoogleMaps();
        }
        catch (Exception e) {
            this.name = "No data";
            this.capital = "No data";
            this.area = "No data";
            this.population = -1;
            this.googleMaps = "No data";
        }
        try {
            this.deaths = covid.getLatest_data().getDeaths();
            this.confirmed = covid.getLatest_data().getConfirmed();
            this.recovered = covid.getLatest_data().getRecovered();
            this.critical = covid.getLatest_data().getCritical();
            this.death_rate = covid.getLatest_data().getCalculated().getDeath_rate();
            this.recovery_rate = covid.getLatest_data().getCalculated().getRecovery_rate();
            this.cases_per_million_population = covid.getLatest_data().getCalculated().getCases_per_million_population();
        } catch (Exception e) {
            this.deaths = -1;
            this.confirmed = -1;
            this.recovered = -1;
            this.critical = -1;
            this.death_rate = -1;
            this.recovery_rate = -1;
            this.cases_per_million_population = -1;
        }
    }
}
