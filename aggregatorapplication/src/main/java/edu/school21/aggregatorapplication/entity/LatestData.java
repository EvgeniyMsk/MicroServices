package edu.school21.aggregatorapplication.entity;

import lombok.Data;

@Data
public class LatestData {
    private int deaths;
    private int confirmed;
    private int recovered;
    private int critical;
    private Calculated calculated;

    @Override
    public String toString() {
        return "LatestData{" +
                "deaths=" + deaths +
                ", confirmed=" + confirmed +
                ", recovered=" + recovered +
                ", critical=" + critical +
                ", calculated=" + calculated +
                '}';
    }
}