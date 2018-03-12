package com.bignerdranch.android.tilesofelinorwithtz;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by Pavlo on 12.03.2018.
 */

public class Test extends Activity {
  String s= "Dungeons";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = findViewById(R.id.Districts);
        AssetManager am =getApplicationContext().getAssets();

       // ArrayAdapter ar =  new ArrayAdapter(this, android.R.layout.simple_list_item_1,Files) ;
       // ar,get
        try {
            String[] Files = am.list(s);
            final ArrayAdapter ar =  new ArrayAdapter(this, android.R.layout.simple_list_item_1,Files) ;
            list.setAdapter(ar);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    TextView txt= (TextView) view;
                    s= s+ "/"+txt.getText().toString();
                    Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG ).show();

                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
