package edu.school21.aggregatorapplication.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Country {
    private Name name;
    private String[] tld;
    private boolean independent;
    private String[] capital;
    private String[] altSpellings;
    private String region;
    private String subregion;
    private String[] latlng;
    private String[] borders;
    private String area;
    private Maps maps;
    private int population;
    private String[] timezones;
}
