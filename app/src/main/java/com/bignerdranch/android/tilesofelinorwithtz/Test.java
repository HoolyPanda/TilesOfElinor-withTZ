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
import java.io.InputStream;

/**
 * Created by Pavlo on 12.03.2018.
 */

public class Test extends Activity {
  String s= "Dungeons";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enterthedungeon);
      TextView txt= findViewById(R.id.textView);
        AssetManager am =getApplicationContext().getAssets();
        try {
            InputStream input=am.open("Dungeons/43 Старый Холм/Зал Костей Событие/description.txt") ;
            int size = input.available();
            byte[] buffer = new byte[size]; //declare the size of the byte array with size of the file
            input.read(buffer); //read file
            input.close(); //close file

// Store text file data in the string variable
            String str_data = new String(buffer, "UTF-8");
           // Toast toast = Toast.makeText(this, str_data , Toast.LENGTH_SHORT );
            //toast.show();


            txt.setText(str_data);
        } catch (IOException e) {
            Toast toast = Toast.makeText(this,"error", Toast.LENGTH_SHORT );
            toast.show();
            e.printStackTrace();
        }


    }


}
