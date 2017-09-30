package de.dortmund.dohack2017.recipeswiper.db;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import de.dortmund.dohack2017.recipeswiper.models.Rezept;
import de.dortmund.dohack2017.recipeswiper.models.Zutat;

/**
 * Created by Sebastian on 30.09.2017.
 */

public class RecipeDataProvider {
    public static List<Rezept> rezeptList;
    static{
        addRezept(new Rezept(
                "",
                "",
                new ArrayList<Zutat>() {

                }
        ));
    }
    private static void addRezept(Rezept rezept){
        rezeptList.add(rezept);
    }
}
