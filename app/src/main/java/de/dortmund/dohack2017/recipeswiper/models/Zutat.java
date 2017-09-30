package de.dortmund.dohack2017.recipeswiper.models;

/**
 * Created by Sebastian on 30.09.2017.
 */

public class Zutat {
    private double menge;
    private String einheit;
    private String name;

    public double getMenge() {
        return menge;
    }

    public void setMenge(double menge) {
        this.menge = menge;
    }

    public String getEinheit() {
        return einheit;
    }

    public void setEinheit(String einheit) {
        this.einheit = einheit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
