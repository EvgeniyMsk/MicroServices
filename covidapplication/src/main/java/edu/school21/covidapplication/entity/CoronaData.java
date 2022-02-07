package edu.school21.covidapplication.entity;

import lombok.Data;

@Data
public class CoronaData {
    private Country[] data;
    private boolean _cacheHit;
}
