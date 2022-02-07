package edu.school21.aggregatorapplication.entity;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Covid {
    private String name;
    private String code;
    private int population;
    private String updated_at;
    private LatestData latest_data;
}
