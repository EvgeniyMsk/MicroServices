package edu.school21.countriesapplication.entity;

import lombok.Data;

@Data
public class NativeName {
    private Rus rus;

    @Override
    public String toString() {
        return "NativeName{" +
                "rus=" + rus +
                '}';
    }
}
