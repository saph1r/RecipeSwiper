package de.dortmund.dohack2017.recipeswiper.features;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.List;

import de.dortmund.dohack2017.recipeswiper.R;
import de.dortmund.dohack2017.recipeswiper.db.RecipeDataProvider;
import de.dortmund.dohack2017.recipeswiper.db.RecipeSwiperDataSource;
import de.dortmund.dohack2017.recipeswiper.models.Rezept;
import de.dortmund.dohack2017.recipeswiper.models.SwipeResults;


public class MainActivity extends AppCompatActivity {



    private TextView mTextMessage;
    private ArrayList<SwipeCard> al;
    private SwipeCardAdapter arrayAdapter;
    private int i;
    private RecipeSwiperDataSource recipeSwiperDataSource;
    private static boolean dataSourceIsOpen = false;
    private SwipeResults swipeResults = new SwipeResults();
    private Intent myIntent;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    return true;
                case R.id.navigation_dashboard: //RezeptListe
                    myIntent = new Intent(MainActivity.this,RezeptListeActivity.class);
                    nextActivity();
                    return true;
                case R.id.navigation_notifications:

                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setDatabase();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        final SwipeFlingAdapterView flingAdapterView = (SwipeFlingAdapterView) findViewById(R.id.swipe);

        List<Rezept> rezepts = recipeSwiperDataSource.getAllRezepts();

        al = new ArrayList<SwipeCard>();
        for(Rezept rezept: rezepts){
            al.add(new SwipeCard(rezept));
        }

        arrayAdapter = new SwipeCardAdapter(this, getLayoutInflater(), al);

        flingAdapterView.setAdapter(arrayAdapter);
        flingAdapterView.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                Log.d("LIST", "removed object");
                al.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object o) { //Verwerfen
                SwipeCard sc = (SwipeCard)o;
                Rezept rararar = sc.getRezept();
                swipeResults.add(rararar, false);
            }

            @Override
            public void onRightCardExit(Object o) { //"Like"
                swipeResults.add(((SwipeCard)o).getRezept(),true);
            }

            @Override
            public void onAdapterAboutToEmpty(int i) {
                arrayAdapter.notifyDataSetChanged();
                Log.d("LIST", "notified");
                i++;
            }

            @Override
            public void onScroll(float scrollProgressPercent) {
//                View view = flingAdapterView.getSelectedView();
//                view.findViewById(R.id.item_swipe_right_indicator).setAlpha(scrollProgressPercent < 0 ? -scrollProgressPercent : 0);
//                view.findViewById(R.id.item_swipe_left_indicator).setAlpha(scrollProgressPercent > 0 ? scrollProgressPercent : 0);
            }
        });

        flingAdapterView.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int i, Object o) {
                makeToast(MainActivity.this, "Clicked");
            }
        });

    }

    static void makeToast(Context ctx, String s){
        Toast.makeText(ctx, s, Toast.LENGTH_SHORT).show();
    }

    private void setDatabase(){
        recipeSwiperDataSource = new RecipeSwiperDataSource();
        recipeSwiperDataSource.open();
        if(!dataSourceIsOpen) {
            for (Rezept rezept : RecipeDataProvider.rezeptList) {
                recipeSwiperDataSource.createRezept(rezept);
            }
            dataSourceIsOpen=true;
        }
    }

    private void nextActivity()
    {
        myIntent.putExtra("swipeResults",swipeResults);
        startActivity(myIntent);
    }
}
