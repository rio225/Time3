package com.example.time3.CS;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.time3.DBASE.ItemAdapter;
import com.example.time3.DBASE.Subject;
import com.example.time3.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class Csmonday extends AppCompatActivity {

    ListView lv;
    BottomNavigationView bottomnavDays,bottomnavActs;
//    RelativeLayout expandedLay;
//    ImageView icDownarrow,icUparrow;
//    MaterialCardView cardView;

    String url = "http://10.0.2.2/www/index.php/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csmonday);

       // lv = (ListView) findViewById(R.id.lv);

        lv= findViewById(R.id.lv);

        bottomnavDays = findViewById(R.id.bottomnavDays);

        // For the bottom navigation of DAYS

       // bottomnavDays.setOnItemSelectedListener(navListener);

        new Downloader(Csmonday.this,url,lv).execute();


        // Construct the data source
        ArrayList<Subject> players = new ArrayList<Subject>();
        // Create the adapter to convert the array to views
        ItemAdapter adapter = new ItemAdapter(this, players);
       // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.lv);
        listView.setAdapter(adapter);



       /* icDownarrow.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                if (expandedLay.getVisibility() == View.GONE) {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandedLay.setVisibility(View.VISIBLE);
                    icDownarrow.setVisibility(View.GONE);
                } else {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandedLay.setVisibility(View.GONE);
                }
            }
        });*/
    }

    private NavigationBarView.OnItemSelectedListener navListener = new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            return false;
        }
    };
}