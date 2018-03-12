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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dungoselect);
        ListView list = findViewById(R.id.list1);
        AssetManager am =getApplicationContext().getAssets();

        try {
            String[] Files = am.list( getIntent().getStringExtra("newpath"));
            ArrayAdapter ar =  new ArrayAdapter(this, android.R.layout.simple_list_item_1,Files) ;
            list.setAdapter(ar);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String path = getIntent().getStringExtra("newpath");
                    TextView txt= (TextView) view;
                     String s= path+ "/"+txt.getText().toString();
                    if(s.equals("Dungeons/43 Старый Холм/Зал Костей 1")){Toast.makeText(getApplicationContext(), path, Toast.LENGTH_LONG ).show();}
                    Intent intent = new Intent(DungeonSelect .this, EnterTheDungeon.class);
                    intent.putExtra("newpath1",s);
                    startActivity(intent);
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

}
}
