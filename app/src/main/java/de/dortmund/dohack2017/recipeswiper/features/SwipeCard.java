package de.dortmund.dohack2017.recipeswiper.features;

/**
 * Created by downh on 30.09.2017.
 */

public class SwipeCard {
    private String text1;
    private int imageId;

    public SwipeCard(String text1, int imageId) {
        this.text1 = text1;
        this.imageId = imageId;
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
