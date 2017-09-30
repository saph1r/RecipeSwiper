package de.dortmund.dohack2017.recipeswiper.db;

import android.util.Log;

/**
 * Created by Sebastian on 30.09.2017.
 */

public class RecipeDataProvider {
    private static final String TAG = EntscheidomatDataSource.class.getSimpleName();

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
}
