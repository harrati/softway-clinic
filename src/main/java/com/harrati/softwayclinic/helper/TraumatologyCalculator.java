package com.harrati.softwayclinic.helper;

public class TraumatologyCalculator implements PathologyCalculator {
    public String calculate(int healthIndex){
        if (healthIndex % 3 == 0) {
            return "Traumatologie";
        }

        return null;
    }
}
