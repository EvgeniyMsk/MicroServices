package edu.school21.aggregatorapplication.entity;

import lombok.Data;

@Data
public class AggregatedInformation {
    private String name;
    private String capital;
    private String region;
    private boolean independent;
    private int population;
    private String[] borders;
    private String flag;
    private String area;
    private int deaths;
    private int confirmed;
    private int recovered;
    private int critical;
    private float death_rate;
    private float recovery_rate;
    private int cases_per_million_population;

    public AggregatedInformation(Country country, Covid covid) {
        try {
            this.name = country.getName();
            this.capital = country.getCapital();
            this.region = country.getRegion();
            this.independent = country.isIndependent();
            this.population = country.getPopulation();
            this.borders = country.getBorders();
            this.flag = country.getFlag();
            this.area = country.getArea();

        }
        catch (Exception e) {
            this.name = "No data";
            this.capital = "No data";
            this.region = "No data";
            this.independent = false;
            this.population = 0;
            this.borders = new String[0];
            this.flag = "No data";
            this.area = "No data";
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
