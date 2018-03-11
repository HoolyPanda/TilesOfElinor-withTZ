package com.bignerdranch.android.tilesofelinorwithtz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Pavlo on 11.03.2018.
 */

public class DungeonSelect extends Activity  {
   static  String dungeon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dungoselect);
        ListView Dungeons = findViewById(R.id.list1);
        int paht = getResources().getIdentifier(MainActivity.district, "array" , getPackageName());
        String[] DungeonList = getResources().getStringArray(paht);
        ArrayAdapter<String>  adapter = new ArrayAdapter<String>(this,  android.R.layout.simple_list_item_1, DungeonList);
        Dungeons.setAdapter(adapter);
        Main(Dungeons);
    }
void Main(ListView Dungeons){
    Dungeons.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
            TextView tv = (TextView) itemClicked ;
            dungeon = tv.getText().toString();
           // dungeon  = dungeon.toLowerCase();
            Intent intent = new Intent(DungeonSelect.this, EnterTheDungeon.class);
            startActivity(intent);
        }
    });

}
}
