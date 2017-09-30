package de.dortmund.dohack2017.recipeswiper.db;

import android.util.Log;

import de.dortmund.dohack2017.recipeswiper.models.Rezept;
import io.realm.Realm;
import io.realm.annotations.RealmClass;

/**
 * Created by Sebastian on 30.09.2017.
 */

public class RecipeSwiperDataSource {
    private static final String TAG = RecipeSwiperDataSource.class.getSimpleName();

    private Realm realm;

    public void open()
    {
        realm = Realm.getDefaultInstance();

        Log.d(TAG,"open: database opened");
    }

    public void close(){
        realm.close();
        Log.d(TAG,"close:database closed");
    }
    public void createRezept(final Rezept rezept){
        realm.executeTransaction(new Realm.Transaction()
        {
            @Override
            public void execute(Realm realm){
                realm.insert(rezept);
            }
        });
    }
}
