
package com.alextroy.testretro;

public class Currency {

    private String name;
    private double rate;

    public Currency(String name, double rate) {
        this.name = name;
        this.rate = rate;
    }

    public Currency(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getRate() {
        return rate;
    }
}

