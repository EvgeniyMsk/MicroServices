package edu.school21.covidapplication.entity;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Country {
    private String name;
    private String code;
    private int population;
    private String updated_at;
    private LatestData latest_data;
}
