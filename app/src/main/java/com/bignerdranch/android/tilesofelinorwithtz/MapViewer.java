package com.bignerdranch.android.tilesofelinorwithtz;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.webkit.WebView;

/**
 * Created by Pavlo on 11.03.2018.
 */

public class MapViewer extends Activity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapviewer);
       // Fragment fr1= findViewById(R.id.map);


        WebView Map= findViewById(R.id.map);//"file:///android_asset/" + res+".html"
        String res= MainActivity.district;
        FloatingActionButton fab2= findViewById(R.id.floatingActionButton3);
        String file= "file:///android_asset/" + res+".html";
        Map.getSettings().setSupportZoom(true);
        Map.getSettings().setBuiltInZoomControls(true);
       // Map.getSettings().supportZoom();
        Map.loadUrl(file);
        if (res == "elinormap"){
            fab2.hide();
        }
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapViewer.this, EncounterList.class);
                startActivity(intent);
            }
        });
    }

}
