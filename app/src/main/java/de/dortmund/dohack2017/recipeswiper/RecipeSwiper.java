package de.dortmund.dohack2017.recipeswiper;

import android.app.Application;

import java.util.regex.Pattern;

import de.dortmund.dohack2017.recipeswiper.db.RecipeDataProvider;
import de.dortmund.dohack2017.recipeswiper.db.RecipeSwiperDataSource;
import de.dortmund.dohack2017.recipeswiper.models.Rezept;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Sebastian on 01.10.2017.
 */

public class RecipeSwiper extends Application {
    public void onCreate(){
        super.onCreate();
        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name("recipeswiper.realm")
                .deleteRealmIfMigrationNeeded()
                .build();
        //Löscht die Database zu Beginn, für die Entwicklung, später removen
        Realm.deleteRealm(configuration);

        Realm.setDefaultConfiguration(configuration);
    }
}
