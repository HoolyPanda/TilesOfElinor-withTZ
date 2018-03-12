package com.bignerdranch.android.tilesofelinorwithtz;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
 static String path ="Dungeons";
 static String s= path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = findViewById(R.id.Districts);
        AssetManager am =getApplicationContext().getAssets();

        try {
            String[] Files = am.list(path);
            final ArrayAdapter ar =  new ArrayAdapter(this, android.R.layout.simple_list_item_1,Files) ;
            list.setAdapter(ar);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    TextView txt= (TextView) view;
                    s = path+ "/"+txt.getText().toString();
                    if(s.equals("Dungeons/Старый Холм")){Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG ).show();}

                   Intent intent = new Intent(MainActivity .this, DungeonSelect.class);
                    startActivity(intent);
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
