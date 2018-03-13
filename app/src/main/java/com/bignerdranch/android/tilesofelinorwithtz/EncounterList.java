package com.bignerdranch.android.tilesofelinorwithtz;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by Pavlo on 11.03.2018.
 */

public class EncounterList extends Activity  {
   // static String path ="Dungeons";// static  int i;
    //String p = DungeonSelect.localpath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dungoselect);
        FloatingActionButton fab=findViewById(R.id.fab1);
        TextView label=findViewById(R.id.textView4);
        label.setText("Список Событий");
        AssetManager am =getApplicationContext().getAssets();
        ListView list1 = findViewById(R.id.list1);//"Dungeons/43 Старый Холм/Encounters"

        try {
           String p= getIntent().getStringExtra("dungeon")+"/Encounters";
           // Toast.makeText(EncounterList.this ,p,Toast.LENGTH_SHORT).show() ;
           String[] RawFiles = am.list(p);
            final ArrayAdapter ar =  new ArrayAdapter(this, android.R.layout.simple_list_item_1,RawFiles) ;
            list1.setAdapter(ar);
        } catch (IOException e) {
            e.printStackTrace();
        }
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String  p =getIntent().getStringExtra("dungeon");
                Intent intent = new Intent(EncounterList .this, MapViewer.class);
                intent.putExtra("path", p);
                startActivity(intent);
            }
        });
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String p= getIntent().getStringExtra("dungeon")+"/Encounters";
                TextView txt= (TextView) view;
                String s = p+ "/"+txt.getText().toString();
               // Toast.makeText(EncounterList.this ,s,Toast.LENGTH_SHORT);
                Intent intent = new Intent(EncounterList.this, Encounter.class);
                intent.putExtra("newpath",s);
                startActivity(intent);
            }
        });
    }
}
