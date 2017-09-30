package de.dortmund.dohack2017.recipeswiper.models;

import android.media.Image;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Sebastian on 30.09.2017.
 */

public class Rezept extends RealmObject implements Serializable {
    @PrimaryKey
    private String id = UUID.randomUUID().toString();
    private String name;
    private String zubereitung;
    private RealmList<Zutat> zutaten;

    public Rezept(){

    }

    public Rezept(String name, String zubereitung) {
        this.name = name;
        this.zubereitung = zubereitung;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZubereitung() {
        return zubereitung;
    }

    public void setZubereitung(String zubereitung) {
        this.zubereitung = zubereitung;
    }

    public List<Zutat> getZutaten() {
        return zutaten;
    }

    public void setZutaten(RealmList<Zutat> zutaten) {
        this.zutaten = zutaten;
    }

    public void printZutaten()
    {
        for(Zutat z : zutaten)
        {
            z.print();
        }
    }

    public void print()
    {
        System.out.print(name + "\n" + zubereitung);
        printZutaten();
    }
}
