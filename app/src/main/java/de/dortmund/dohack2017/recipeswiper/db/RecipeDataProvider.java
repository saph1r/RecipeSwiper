package de.dortmund.dohack2017.recipeswiper.db;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.dortmund.dohack2017.recipeswiper.models.Rezept;
import de.dortmund.dohack2017.recipeswiper.models.Zutat;
import io.realm.RealmList;

/**
 * Created by Sebastian on 30.09.2017.
 */

public class RecipeDataProvider {
    public static List<Rezept> rezeptList;
    public static List<Zutat> zutatList;
    static{
        addZutatenListe();
        addRezept(new Rezept(
                "Tomaten-Basilikum-Suppe",
                "Arbeitszeit: ca. 20 Min. / Koch-/Backzeit: ca. 15 Min. / Schwierigkeitsgrad: normal / Kalorien p. P.: ca. 136 kcal\n" +
                        "\n" +
                        "Tomatenhaut am Stielansatz kreuzweise einritzen und kurz in kochendes Wasser tauchen, mit kaltem Wasser abschrecken. Dann die Tomatenhaut abziehen und dann die geschälten Tomaten würfeln. \n" +
                        "Vier Basilikumblätter, die Schalotte und den Knoblauch schälen und fein hacken.\n" +
                        "\n" +
                        "Butter in einem Topf schmelzen, Schalotten- und Knoblauchwürfel zugeben. Nach kurzem Andünsten die Tomatenstücke in den Topf geben und kurz mitdünsten, danach die Brühe angießen. Die Suppe nun 10 Minuten zugedeckt köcheln lassen. Die Suppe pürieren und durch ein feines Sieb gießen, um Schalottenstückchen und Tomatenkerne zu entfernen. Das fein gehackte Basilikum einrühren. Nun mit Salz, Pfeffer und ggf. Zucker oder Stevia abschmecken. Die Suppe auf vier Teller verteilen, mit je 1 TL Olivenöl und 1 Basilikumblatt garnieren."
                ),
                new Zutat("800","g","Tomaten"),
                new Zutat("20","g","Butter"),
                new Zutat("1","","Schalotten"),
                new Zutat("250","ml","Gemüsebrühe"),
                new Zutat("4","TL","Olivenöl"),
                new Zutat("","n.B.","Salz"),
                new Zutat("","n.B.","Pfeffer"),
                new Zutat("","etwas","Zucker")
        );
    }
    private static void addRezept(Rezept rezept, Zutat... zutaten){
        if(zutaten.length > 0){
            rezept.setZutaten(new RealmList<Zutat>());
            rezept.getZutaten().addAll(Arrays.asList(zutaten));
        }
        rezeptList.add(rezept);
    }
    private static void addZutatenListe(){
        new ArrayList<Zutat>(){

        };
    }
    private static void addZutat(Zutat zutat){
        zutatList.add(zutat);
    }
}
