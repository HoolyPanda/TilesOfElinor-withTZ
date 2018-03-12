package com.bignerdranch.android.tilesofelinorwithtz;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Pavlo on 11.03.2018.
 */

public class Encounter extends Activity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.encounterdiscription);
        TextView discription= findViewById(R.id.textView3);
        int path = getResources().getIdentifier( EncounterList.encounterlist +"discr","array",getPackageName()) ;
        String [] discriptions= getResources().getStringArray(path);
        discription.setText(discriptions[EncounterList.i] );


    }
}
