package com.bignerdranch.android.tilesofelinorwithtz;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
static String district;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView Districts= findViewById(R.id.Districts);
        String[] DistrictList = getResources().getStringArray(R.array.districts);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,  android.R.layout.simple_list_item_1, DistrictList);


        FloatingActionButton Map= findViewById(R.id.abb) ;
        Map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               district = "elinormap";
                Intent intent= new Intent(MainActivity.this , MapViewer .class );
                startActivity(intent);
            }
        });

        Districts.setAdapter(adapter);
        Main(Districts);

    }
 void Main(ListView districts){
     districts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
             TextView tv = (TextView) itemClicked ;
             district = tv.getText().toString();
             district = district.toLowerCase();
             district = district.replace(" ","");
             Intent intent = new Intent(MainActivity.this, DungeonSelect.class);
             startActivity(intent);
         }
     });
 }
}
