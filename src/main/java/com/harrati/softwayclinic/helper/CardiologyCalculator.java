package com.harrati.softwayclinic.helper;

public class CardiologyCalculator implements PathologyCalculator {
    public String calculate(int healthIndex){
        if (healthIndex % 5 == 0) {
            return "Cardiologie";
        }
        return null;
    }
}
