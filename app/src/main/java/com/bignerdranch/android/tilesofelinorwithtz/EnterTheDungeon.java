package com.bignerdranch.android.tilesofelinorwithtz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.view.DragEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.DragEvent.ACTION_DRAG_STARTED;

/**
 * Created by Pavlo on 11.03.2018.
 */

public class EnterTheDungeon extends Activity  {
    static String path1= DungeonSelect.path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enterthedungeon);
        TextView MainDiscription, ToEnter;
       MainDiscription = findViewById(R.id.textView);
       ToEnter = findViewById(R.id.textView2);
        Main(MainDiscription , ToEnter );
    }
    void Main (TextView  MainDiscription, TextView ToEnter){
       // TextView MainDiscription, ToEnter;
        Button button= findViewById(R.id.button);
        ConstraintLayout back =findViewById(R.id.background);

        FloatingActionButton fab= findViewById(R.id.floatingActionButton2);

        path1= path1.toLowerCase();
        path1= path1.replace(" ","");
        int path= getResources().getIdentifier(path1,"array",getPackageName()) ;

        final String[] dungeondescription= getResources().getStringArray(path);
        MainDiscription.setText(dungeondescription[0]);
        ToEnter.setText(dungeondescription[1]);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 MainActivity.path= path1;
                Intent intent= new Intent(EnterTheDungeon.this , MapViewer .class );
                startActivity(intent);
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), dungeondescription[2], Toast.LENGTH_LONG ).show();
            }
        });


    }
}
