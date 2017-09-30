package de.dortmund.dohack2017.recipeswiper.features;

import de.dortmund.dohack2017.recipeswiper.models.Rezept;

/**
 * Created by downh on 30.09.2017.
 */

public class SwipeCard {
    private String text1;
    private int imageId;

    public SwipeCard(Rezept rezept) {
        this.text1 = rezept.getName();
        this.imageId = rezept.getImageResourceId();
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
