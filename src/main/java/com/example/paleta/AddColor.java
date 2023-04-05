package com.example.paleta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;

public class AddColor extends AppCompatActivity {

    private ImageView c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;
    private Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10;
    DBHelper db;
    private Integer pid;
    private ArrayList<Integer> allColors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_color);

        db = new DBHelper(this);
        pid = db.getCurrentPalette();
        allColors = db.getAllColors(pid);
        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        c4 = findViewById(R.id.c4);
        c5 = findViewById(R.id.c5);
        c6 = findViewById(R.id.c6);
        c7 = findViewById(R.id.c7);
        c8 = findViewById(R.id.c8);
        //c9 = findViewById(R.id.c9);
        //c10 = findViewById(R.id.c10);
        if(allColors!=null){
            if(allColors.size()>=5){c1.setBackgroundColor(allColors.get(4));}
            if(allColors.size()>=6){c2.setBackgroundColor(allColors.get(5));}
            if(allColors.size()>=7){c3.setBackgroundColor(allColors.get(6));}
            //if(allColors.size()>=8){c4.setBackgroundColor(allColors.get(7));}
            if(allColors.size()>=9){c5.setBackgroundColor(allColors.get(8));}
            if(allColors.size()>=10){c6.setBackgroundColor(allColors.get(9));}
            //if(allColors.size()>=7){c7.setBackgroundColor(allColors.get(6));}
            //if(allColors.size()>=8){c8.setBackgroundColor(allColors.get(7));}
            //if(allColors.size()>=9){c9.setBackgroundColor(allColors.get(8));}
            //if(allColors.size()>=10){c10.setBackgroundColor(allColors.get(9));}
        }

        findViewById(R.id.ExitAddColor).setOnClickListener( new View.OnClickListener() {@Override public void onClick( View v ) {
            returnToPE(); }
        });
        (findViewById(R.id.b1)).setOnClickListener( new View.OnClickListener() {@Override public void onClick( View v ) {
            db.insertSavedColors(allColors.get(4), pid); returnToPE(); }
        });
        (findViewById(R.id.b2)).setOnClickListener( new View.OnClickListener() {@Override public void onClick( View v ) {
            db.insertSavedColors(allColors.get(5), pid); returnToPE(); }
        });
        (findViewById(R.id.b3)).setOnClickListener( new View.OnClickListener() {@Override public void onClick( View v ) {
            db.insertSavedColors(allColors.get(6), pid); returnToPE(); }
        });
        (findViewById(R.id.b4)).setOnClickListener( new View.OnClickListener() {@Override public void onClick( View v ) {
            db.insertSavedColors(allColors.get(7), pid); returnToPE(); }
        });
        (findViewById(R.id.b5)).setOnClickListener( new View.OnClickListener() {@Override public void onClick( View v ) {
            db.insertSavedColors(allColors.get(8), pid); returnToPE(); }
        });
        (findViewById(R.id.b6)).setOnClickListener( new View.OnClickListener() {@Override public void onClick( View v ) {
            db.insertSavedColors(allColors.get(9), pid); returnToPE(); }
        });
        (findViewById(R.id.b7)).setOnClickListener( new View.OnClickListener() {@Override public void onClick( View v ) {
            db.insertSavedColors(allColors.get(6), pid); returnToPE(); }
        });
        (findViewById(R.id.b8)).setOnClickListener( new View.OnClickListener() {@Override public void onClick( View v ) {
            db.insertSavedColors(allColors.get(7), pid); returnToPE(); }
        });

    }

    public void returnToPE(){
        Intent intent = new Intent( this, PaletteEditorActivity.class );
        startActivity( intent );
    }

}