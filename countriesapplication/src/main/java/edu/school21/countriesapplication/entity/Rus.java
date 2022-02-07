package edu.school21.countriesapplication.entity;

import lombok.Data;

@Data
public class Rus {
    private String official;
    private String common;

    @Override
    public String toString() {
        return "Rus{" +
                "official='" + official + '\'' +
                ", common='" + common + '\'' +
                '}';
    }
}
