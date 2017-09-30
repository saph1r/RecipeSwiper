package de.dortmund.dohack2017.recipeswiper.models;

import java.io.Serializable;
import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Sebastian on 30.09.2017.
 */

public class Zutat extends RealmObject implements Serializable{

    @PrimaryKey
    private String id = UUID.randomUUID().toString();
    private String menge;
    private String einheit;
    private String name;

    public Zutat(){

    }
    public Zutat(String menge, String einheit, String name){
        this.menge =menge;
        this.einheit=einheit;
        this.name=name;
    }

    public String getMenge() {
        return menge;
    }

    public void setMenge(String menge) {
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

    public void print()
    {
        System.out.println(name +" : "+ menge + einheit);
    }
}
