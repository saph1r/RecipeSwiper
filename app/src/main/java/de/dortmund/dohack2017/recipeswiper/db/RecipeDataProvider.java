package de.dortmund.dohack2017.recipeswiper.db;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.dortmund.dohack2017.recipeswiper.R;
import de.dortmund.dohack2017.recipeswiper.models.Rezept;
import de.dortmund.dohack2017.recipeswiper.models.Zutat;
import io.realm.RealmList;

/**
 * Created by Sebastian on 30.09.2017.
 */

public class RecipeDataProvider {
    public static List<Rezept> rezeptList;

    static{
        addRezept(new Rezept(
                "Tomaten-Basilikum-Suppe",
                "Arbeitszeit: ca. 20 Min. / Koch-/Backzeit: ca. 15 Min. / Schwierigkeitsgrad: normal / Kalorien p. P.: ca. 136 kcal\n" +
                        "\n" +
                        "Tomatenhaut am Stielansatz kreuzweise einritzen und kurz in kochendes Wasser tauchen, mit kaltem Wasser abschrecken. Dann die Tomatenhaut abziehen und dann die geschälten Tomaten würfeln. \n" +
                        "Vier Basilikumblätter, die Schalotte und den Knoblauch schälen und fein hacken.\n" +
                        "\n" +
                        "Butter in einem Topf schmelzen, Schalotten- und Knoblauchwürfel zugeben. Nach kurzem Andünsten die Tomatenstücke in den Topf geben und kurz mitdünsten, danach die Brühe angießen. Die Suppe nun 10 Minuten zugedeckt köcheln lassen. Die Suppe pürieren und durch ein feines Sieb gießen, um Schalottenstückchen und Tomatenkerne zu entfernen. Das fein gehackte Basilikum einrühren. Nun mit Salz, Pfeffer und ggf. Zucker oder Stevia abschmecken. Die Suppe auf vier Teller verteilen, mit je 1 TL Olivenöl und 1 Basilikumblatt garnieren."
                ,R.drawable.tomaten_basilikum_suppe),
                new Zutat("800","g","Tomaten"),
                new Zutat("20","g","Butter"),
                new Zutat("1","","Schalotten"),
                new Zutat("250","ml","Gemüsebrühe"),
                new Zutat("4","TL","Olivenöl"),
                new Zutat("","n.B.","Salz"),
                new Zutat("","n.B.","Pfeffer"),
                new Zutat("","etwas","Zucker")
        );
        addRezept(new Rezept(
                        "Hackbraten mit Kartoffeln in Sahne",
                        "Arbeitszeit: ca. 30 Min. / Schwierigkeitsgrad: simpel / Kalorien p. P.: keine Angabe\n" +
                                "\n" +
                                "Das Hackfleisch mit Salz, Pfeffer, Paniermehl, Ei und Paprikapulver verkneten.\n" +
                                "Backofen vorheizen.\n" +
                                "Die Hälfte davon in die Mitte einer gefetteten Auflaufform geben. Rings herum etwas Platz lassen. Den Schafskäse in Scheiben schneiden, auf das Hackfleisch legen. Die andere Hälfte des Hackfleischs obenauf, so dass der Käse bedeckt ist.\n" +
                                "Kartoffeln schälen und in dünne Scheiben schneiden. Die Kartoffelscheiben rings um den Hackbraten verteilen. Mit etwas Salz bestreuen. Die mit Brühe vermischte Sahne über die Kartoffeln geben, so dass diese richtig bedeckt sind. Wer mag, würzt die Kartoffel-Sahne-Masse mit Muskat, geht aber auch ohne.\n" +
                                "Ab damit in den Backofen, ca. 1 Stunde bei 200 °C.\n" +
                                "Guten Appetit!",R.drawable.hackbraten_mit_kartoffeln_in_sahne),
                new Zutat("700","g","Hackfleisch"),
                new Zutat("1","","Ei"),
                new Zutat("","","Paniermehl"),
                new Zutat("","etwas","Gemüsebrühe"),
                new Zutat("2","Becher","Sahne"),
                new Zutat("","n.B.","Salz"),
                new Zutat("","n.B.","Pfeffer"),
                new Zutat("","n.B.","Paprikapulver"),
                new Zutat("8","","Kartoffeln"),
                new Zutat("1","Stück","Schafskäse"),
                new Zutat("","etwas","Muskat")
        );
        addRezept(new Rezept(
                        "Spaghetti Carbonara",
                        "Arbeitszeit: ca. 5 Min. / Koch-/Backzeit: ca. 15 Min. / Schwierigkeitsgrad: simpel / Kalorien p. P.: keine Angabe\n" +
                                "\n" +
                                "Die Pasta in reichlich Salzwasser bissfest kochen. Den Schinken in Würfel schneiden und in wenig Butter anbraten. \n" +
                                "\n" +
                                "Eigelb in einer großen Schüssel mit Salz, Pfeffer und Muskat verquirlen. Die Butter schaumig rühren und gut unter das Eigelb mischen. Die Schinkenwürfel und den geriebenen Käse gründlich unterrühren.\n" +
                                "\n" +
                                "Wenn die Nudeln gar sind, abgießen, sofort zu der Mischung in die Schüssel geben, nochmal alles gründlich durchmischen, dann sogleich servieren.",R.drawable.spaghetti_carbonara),
                new Zutat("400","g","Tortellini"),
                new Zutat("200","g","Schinken"),
                new Zutat("4","","Eigelb"),
                new Zutat("50","g","Butter"),
                new Zutat("","n.B.","Salz"),
                new Zutat("","n.B.","Pfeffer"),
                new Zutat("","etwas","Muskat"),
                new Zutat("","n.B.","Parmsan")
        );
    }
    private static void addRezept(Rezept rezept, Zutat... zutaten){
        if(zutaten.length > 0){
            rezept.setZutaten(new RealmList<Zutat>());
            rezept.getZutaten().addAll(Arrays.asList(zutaten));
        }
        rezeptList.add(rezept);
    }
}
