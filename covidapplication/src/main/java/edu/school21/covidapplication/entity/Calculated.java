package edu.school21.covidapplication.entity;

import lombok.Data;

@Data
public class Calculated {
    private float death_rate;
    private float recovery_rate;
    private int cases_per_million_population;

    @Override
    public String toString() {
        return "Calculated{" +
                "death_rate=" + death_rate +
                ", recovery_rate=" + recovery_rate +
                ", cases_per_million_population=" + cases_per_million_population +
                '}';
    }
}
