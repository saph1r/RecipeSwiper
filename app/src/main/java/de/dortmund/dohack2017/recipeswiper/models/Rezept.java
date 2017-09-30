package de.dortmund.dohack2017.recipeswiper.models;

import android.media.Image;

import java.util.List;

/**
 * Created by Sebastian on 30.09.2017.
 */

public class Rezept {
    private Image image;
    private String name;
    private String zubereitung;
    private List<Zutat> zutaten;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
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

    public void setZutaten(List<Zutat> zutaten) {
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
