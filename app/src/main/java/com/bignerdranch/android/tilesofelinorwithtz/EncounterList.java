package com.bignerdranch.android.tilesofelinorwithtz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Pavlo on 11.03.2018.
 */

public class EncounterList extends Activity  {
   static  String encounterlist = DungeonSelect.dungeon;
    String encounter;
   static  int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dungoselect);
        encounterlist = encounterlist.toLowerCase().replace(" ","")+"encounters";

        int res= getResources().getIdentifier(encounterlist, "array",getPackageName());
        ListView Encounters= findViewById(R.id.list1);
        String[] DistrictList = getResources().getStringArray(res);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,  android.R.layout.simple_list_item_1, DistrictList);

        Encounters.setAdapter(adapter);
        Main(Encounters);

    }
    void Main(ListView encounters){
        encounters.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                 i= position ;
                TextView tv = (TextView) itemClicked ;
                encounter  = tv.getText().toString();
                encounter  = encounter.toLowerCase();
                encounter= encounter.replace(" ","");
                Intent intent = new Intent(EncounterList.this, Encounter.class);
                startActivity(intent);
            }
        });
    }
}
