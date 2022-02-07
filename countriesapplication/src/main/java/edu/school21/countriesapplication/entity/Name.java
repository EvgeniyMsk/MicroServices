package edu.school21.countriesapplication.entity;

import lombok.Data;

@Data
public class Name {
    private String common;
    private String official;
    private NativeName nativeName;

    @Override
    public String toString() {
        return "Name{" +
                "common='" + common + '\'' +
                ", official='" + official + '\'' +
                ", nativeName=" + nativeName +
                '}';
    }
}
