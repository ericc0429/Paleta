package com.example.paleta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.net.URI;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final int PICK_IMAGE = 1;
    private Button bCP, p1, p2, p3, p4, p5;
    DBHelper db;
    Uri imageUri;
    ArrayList<Integer> pids;
    ArrayList<Integer> p1c, p2c, p3c, p4c, p5c;
    Integer pid1, pid2, pid3, pid4, pid5 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DBHelper(this);
        pids = db.getPids();
       /*db.deleteAllColorsPalette(pids.get(3));
        db.deleteSavedPalette(pids.get(3));
        db.deletePaletteData(pids.get(3));
        pids.remove(3);*/
        if(pids!=null) {
            if (pids.size() >= 1) {
                pid1 = pids.get(0);
                p1c = db.getSavedColors(pid1);
            }
            if (pids.size() >= 2) {
                pid2 = pids.get(1);
                p2c = db.getSavedColors(pid2);
            }
            if (pids.size() >= 3) {
                pid3 = pids.get(2);
                p3c = db.getSavedColors(pid3);
            }
            if (pids.size() >= 4) {
                pid4 = pids.get(3);
                p4c = db.getSavedColors(pid4);
            }
            if (pids.size() >= 5) {
                pid5 = pids.get(4);
                p5c = db.getSavedColors(pid5);
            }
        }
        // Palette Creation
        bCP = (Button) findViewById(R.id.bCP);
        if(p1c != null) {
            if (p1c.size() >= 1) {
                findViewById(R.id.p1c1).setBackgroundColor(p1c.get(0));
            }
            if (p1c.size() >= 2) {
                findViewById(R.id.p1c2).setBackgroundColor(p1c.get(1));
            }
            if (p1c.size() >= 3) {
                findViewById(R.id.p1c3).setBackgroundColor(p1c.get(2));
            }
            if (p1c.size() >= 4) {
                findViewById(R.id.p1c4).setBackgroundColor(p1c.get(3));
            }
            if (p1c.size() >= 5) {
                findViewById(R.id.p1c5).setBackgroundColor(p1c.get(4));
            }
            if (p1c.size() >= 6) {
                findViewById(R.id.p1c6).setBackgroundColor(p1c.get(5));
            }
            if (p1c.size() >= 7) {
                findViewById(R.id.p1c7).setBackgroundColor(p1c.get(6));
            }
            if (p1c.size() >= 8) {
                findViewById(R.id.p1c8).setBackgroundColor(p1c.get(7));
            }
        }
        if(p2c != null) {
            if (p2c.size() >= 1) {
                findViewById(R.id.p2c1).setBackgroundColor(p2c.get(0));
            }
            if (p2c.size() >= 2) {
                findViewById(R.id.p2c2).setBackgroundColor(p2c.get(1));
            }
            if (p2c.size() >= 3) {
                findViewById(R.id.p2c3).setBackgroundColor(p2c.get(2));
            }
            if (p2c.size() >= 4) {
                findViewById(R.id.p2c4).setBackgroundColor(p2c.get(3));
            }
            if (p2c.size() >= 5) {
                findViewById(R.id.p2c5).setBackgroundColor(p2c.get(4));
            }
            if (p2c.size() >= 6) {
                findViewById(R.id.p2c6).setBackgroundColor(p2c.get(5));
            }
            if (p2c.size() >= 7) {
                findViewById(R.id.p2c7).setBackgroundColor(p2c.get(6));
            }
            if (p2c.size() >= 8) {
                findViewById(R.id.p2c8).setBackgroundColor(p2c.get(7));
            }
        }
        if(p3c != null) {
            if (p3c.size() >= 1) {
                findViewById(R.id.p3c1).setBackgroundColor(p3c.get(0));
            }
            if (p3c.size() >= 2) {
                findViewById(R.id.p3c2).setBackgroundColor(p3c.get(1));
            }
            if (p3c.size() >= 3) {
                findViewById(R.id.p3c3).setBackgroundColor(p3c.get(2));
            }
            if (p3c.size() >= 4) {
                findViewById(R.id.p3c4).setBackgroundColor(p3c.get(3));
            }
            if (p3c.size() >= 5) {
                findViewById(R.id.p3c5).setBackgroundColor(p3c.get(4));
            }
            if (p3c.size() >= 6) {
                findViewById(R.id.p3c6).setBackgroundColor(p3c.get(5));
            }
            if (p3c.size() >= 7) {
                findViewById(R.id.p3c7).setBackgroundColor(p3c.get(6));
            }
            if (p3c.size() >= 8) {
                findViewById(R.id.p3c8).setBackgroundColor(p3c.get(7));
            }
        }
        if(p4c != null) {
            if (p4c.size() >= 1) {
                findViewById(R.id.p4c1).setBackgroundColor(p4c.get(0));
            }
            if (p4c.size() >= 2) {
                findViewById(R.id.p4c2).setBackgroundColor(p4c.get(1));
            }
            if (p4c.size() >= 3) {
                findViewById(R.id.p4c3).setBackgroundColor(p4c.get(2));
            }
            if (p4c.size() >= 4) {
                findViewById(R.id.p4c4).setBackgroundColor(p4c.get(3));
            }
            if (p4c.size() >= 5) {
                findViewById(R.id.p4c5).setBackgroundColor(p4c.get(4));
            }
            if (p4c.size() >= 6) {
                findViewById(R.id.p4c6).setBackgroundColor(p4c.get(5));
            }
            if (p4c.size() >= 7) {
                findViewById(R.id.p4c7).setBackgroundColor(p4c.get(6));
            }
            if (p4c.size() >= 8) {
                findViewById(R.id.p4c8).setBackgroundColor(p4c.get(7));
            }

        }
        if(p5c!=null) {
            if (p5c.size() >= 1) {
                findViewById(R.id.p5c1).setBackgroundColor(p5c.get(0));
            }
            if (p5c.size() >= 2) {
                findViewById(R.id.p5c2).setBackgroundColor(p5c.get(1));
            }
            if (p5c.size() >= 3) {
                findViewById(R.id.p5c3).setBackgroundColor(p5c.get(2));
            }
            if (p5c.size() >= 4) {
                findViewById(R.id.p5c4).setBackgroundColor(p5c.get(3));
            }
            if (p5c.size() >= 5) {
                findViewById(R.id.p5c5).setBackgroundColor(p5c.get(4));
            }
            if (p5c.size() >= 6) {
                findViewById(R.id.p5c6).setBackgroundColor(p5c.get(5));
            }
            if (p5c.size() >= 7) {
                findViewById(R.id.p5c7).setBackgroundColor(p5c.get(6));
            }
            if (p5c.size() >= 8) {
                findViewById(R.id.p5c8).setBackgroundColor(p5c.get(7));
            }

        }


        // Palette Editor Buttons
        p1 = (Button) findViewById(R.id.p1);
        //get lsit of pids
        //get list of colors by pid

        p1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                if(pid1!=0){
                db.setCurrentPalette(pid1);
                openPE();}
            }
        });
        p2 = (Button) findViewById(R.id.p2);
        p2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                if(pid2!=0){
                db.setCurrentPalette(pid2);
                openPE();}
            }
        });
        p3 = (Button) findViewById(R.id.p3);
        p3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                if(pid3!=0){
                db.setCurrentPalette(pid3);
                openPE();}
            }
        });
        p4 = (Button) findViewById(R.id.p4);
        p4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                if(pid4!=0){
                db.setCurrentPalette(pid4);
                openPE();}
            }
        });
        p5 = (Button) findViewById(R.id.p5);
        p5.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                if(pid5!=0){
                db.setCurrentPalette(pid5);
                openPE();}
            }
        });
        bCP.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                openCP();
            }
        });



    }
    // Links to Palette Creator Tool
    public void openCP() {
        Intent intent = new Intent( this, GalleryOrCameraActivity.class );
        startActivity( intent );
    }
    // Links to Palette Editor Tool -- Consider passing a Palette class in with the saved color data.
    public void openPE() {
        Intent intent = new Intent( this, PaletteEditorActivity.class );
        startActivity( intent );
    }


}
