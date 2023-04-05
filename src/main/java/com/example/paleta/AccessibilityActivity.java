package com.example.paleta;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class AccessibilityActivity extends AppCompatActivity {

    DBHelper db;
    private Integer pid;
    private ArrayList<Integer> savedColors;
    private ImageButton color1, color2, color3, color4, color5, color6, color7, color8;
    ContrastChecker checker;
    TextView filter;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accessibility);
        TextView ratio = findViewById(R.id.ContrastLabel);
        db = new DBHelper(this);
        pid = db.getCurrentPalette();
        savedColors = db.getSavedColors(pid);
        checker = new ContrastChecker();

        color1 = findViewById(R.id.Color1);
        color2 = findViewById(R.id.Color2);
        color3 = findViewById(R.id.Color3);
        color4 = findViewById(R.id.Color4);
        color5 = findViewById(R.id.Color5);
        color6 = findViewById(R.id.Color6);
        color7 = findViewById(R.id.Color7);
        color8 = findViewById(R.id.Color8);

        if(savedColors.size()>=1){color1.setBackgroundColor(savedColors.get(0));}
        if(savedColors.size()>=2){color2.setBackgroundColor(savedColors.get(1));}
        if(savedColors.size()>=3){color3.setBackgroundColor(savedColors.get(2));}
        if(savedColors.size()>=4){color4.setBackgroundColor(savedColors.get(3));}
        if(savedColors.size()>=5){color5.setBackgroundColor(savedColors.get(4));}
        if(savedColors.size()>=6){color6.setBackgroundColor(savedColors.get(5));}
        if(savedColors.size()>=7){color7.setBackgroundColor(savedColors.get(6));}
        if(savedColors.size()>=8){color8.setBackgroundColor(savedColors.get(7));}

        //String color = String.valueOf(checker.getGrayScale(savedColors.get(0)));
        //filter = findViewById(R.id.CBFilter1);
        //filter.setText(color);
        //findViewById(R.id.Color1CB1).setBackgroundColor(color);
        if(savedColors.size()>=1){findViewById(R.id.Color1CB1).setBackgroundColor(checker.getGrayScale(savedColors.get(0)));}
        if(savedColors.size()>=2){findViewById(R.id.Color2CB1).setBackgroundColor(checker.getGrayScale(savedColors.get(1)));}
        if(savedColors.size()>=3){findViewById(R.id.Color3CB1).setBackgroundColor(checker.getGrayScale(savedColors.get(2)));}
        if(savedColors.size()>=4){findViewById(R.id.Color4CB1).setBackgroundColor(checker.getGrayScale(savedColors.get(3)));}
        if(savedColors.size()>=5){findViewById(R.id.Color5CB1).setBackgroundColor(checker.getGrayScale(savedColors.get(4)));}
        if(savedColors.size()>=6){findViewById(R.id.Color6CB1).setBackgroundColor(checker.getGrayScale(savedColors.get(5)));}
        if(savedColors.size()>=7){findViewById(R.id.Color7CB1).setBackgroundColor(checker.getGrayScale(savedColors.get(6)));}
        if(savedColors.size()>=8){findViewById(R.id.Color8CB1).setBackgroundColor(checker.getGrayScale(savedColors.get(7)));}

        findViewById(R.id.ExitAccessibility).setOnClickListener( new View.OnClickListener() {@Override public void onClick(View v ) {
            returnToPE(); }
        });

        findViewById(R.id.ContrastColor1).setBackgroundColor(savedColors.get(0));
        findViewById(R.id.ContrastColor2).setBackgroundColor(savedColors.get(1));
        String contrast = checker.getConstrastRatio_new(savedColors.get(0), savedColors.get(1));

        ratio.setText(contrast);


    }

    public void returnToPE(){
        Intent intent = new Intent( this, PaletteEditorActivity.class );
        startActivity( intent );
    }
}