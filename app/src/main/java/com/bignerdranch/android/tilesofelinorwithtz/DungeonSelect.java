package com.bignerdranch.android.tilesofelinorwithtz;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
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
 //   final String localpath= getIntent().getStringExtra("newpath");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dungoselect);
        TextView label=findViewById(R.id.textView4);
        label.setText("Список Подземелий");
        Toast.makeText(getApplicationContext(),"Обязательно уточняйте текущее состояние подземелья у Мастера Подземелий", Toast.LENGTH_LONG ).show();
        ListView list = findViewById(R.id.list1);
        FloatingActionButton fab= findViewById(R.id.fab1);
        fab.setVisibility(View.INVISIBLE);
        AssetManager am =getApplicationContext().getAssets();
        TextView txt1= new TextView(getApplicationContext()); //getIntent().getStringExtra("newpath")
        txt1.setText(getIntent().getStringExtra("newpath"));
        try {
            String[] RawFiles = am.list( getIntent().getStringExtra("newpath"));
            String[] Files = new String[RawFiles.length-3];
            for(Integer i = 0;i!=(RawFiles.length-3);i++){
                Files[i]= RawFiles[i+3];
            }
           // Files[4]= "";
            ArrayAdapter ar =  new ArrayAdapter(this, android.R.layout.simple_list_item_1,Files) ;
            list.setAdapter(ar);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String path = getIntent().getStringExtra("newpath");
                    TextView txt= (TextView) view;
                     String s= path+ "/"+txt.getText().toString();
                  //  if(s.equals("Dungeons/43 Старый Холм/Зал Костей 1")){Toast.makeText(getApplicationContext(), path, Toast.LENGTH_LONG ).show();}
                    Intent intent = new Intent(DungeonSelect .this, EnterTheDungeon.class);
                    intent.putExtra("dungeon", path);
                    intent.putExtra("newpath1",s);
                    startActivity(intent);
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

}
}
