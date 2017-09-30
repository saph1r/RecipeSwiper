package de.dortmund.dohack2017.recipeswiper.features;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.dortmund.dohack2017.recipeswiper.R;
import de.dortmund.dohack2017.recipeswiper.models.Rezept;

public class RezeptListeActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private List<Rezept> rezepte;
    private ListView listView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezept_liste);

        Intent myIntent = getIntent();
        rezepte = (List<Rezept>) myIntent.getSerializableExtra("rezepteJa");

        listView  = (ListView) findViewById(R.id.list);
        List<String> values = new ArrayList<String>();
        for(Rezept r: rezepte)
        {
            values.add(r.getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1,values);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition = position;
                Rezept itemValue = (Rezept) listView.getItemAtPosition(position);
                singleRezeptActivity(itemValue);
            }
        });

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void singleRezeptActivity(Rezept r)
    {
        Intent myIntent = new Intent(RezeptListeActivity.this, RezeptActivity.class);
        myIntent.putExtra("rezept",r);
    }
}
