package com.bignerdranch.android.tilesofelinorwithtz;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by Pavlo on 11.03.2018.
 */

public class DungeonSelect extends Activity  {
   static  String path = MainActivity.s;
   static String s = path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dungoselect); //MainActivity.district

        ListView list = findViewById(R.id.list1);
        AssetManager am =getApplicationContext().getAssets();

        try {
            String[] Files = am.list(path);
            final ArrayAdapter ar =  new ArrayAdapter(this, android.R.layout.simple_list_item_1,Files) ;
            list.setAdapter(ar);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    TextView txt= (TextView) view;
                    path= path+ "/"+txt.getText().toString();
                    if(path.equals("Dungeons/Старый Холм/Зал Костей 1")){Toast.makeText(getApplicationContext(), path, Toast.LENGTH_LONG ).show();}
                   // Intent intent = new Intent(MainActivity .this, DungeonSelect.class);
                    //startActivity(intent);
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

}
}
