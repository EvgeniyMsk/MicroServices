package edu.school21.countriesapplication.entity;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Country {
    private String name;
    private String capital;
    private String region;
    private boolean independent;
    private int population;
    private String[] borders;
    private String flag;
    private String area;
}
