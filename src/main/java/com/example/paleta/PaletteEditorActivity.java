package com.example.paleta;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.palette.graphics.Palette;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.azeesoft.lib.colorpicker.ColorPickerDialog;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import top.defaults.colorpicker.ColorPickerPopup;


import java.util.ArrayList;
import java.util.List;

public class PaletteEditorActivity extends AppCompatActivity {

    private ImageButton color1, color2, color3, color4, color5, color6, color7, color8,  exitBtn, save;
    Button addColor;
    int amtFavs = 8;
    DBHelper db;
    byte[] byteImage;
    private Integer pid;
    ImageDBHelper helper;
    Bitmap bitmap;
    private int mColor;
    private ArrayList<Integer> savedColors;
    private ArrayList<Integer> rids;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette_editor);

        ImageView picture = findViewById(R.id.PictureForPalette);
        db = new DBHelper(this);
        pid = db.getCurrentPalette();
        Context context = getApplicationContext();
        CharSequence text = "Saved";
        int duration = Toast.LENGTH_SHORT;



        /*byteImage = db.getAnImage(pid);
        bitmap = helper.getImage(byteImage);
        picture.setImageBitmap(bitmap);*/

        savedColors = db.getSavedColors(pid);
        rids= db.getRids(pid);

        addColor = findViewById(R.id.AddColor);
        exitBtn = findViewById(R.id.ExitPaletteEditor);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);



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

        findViewById(R.id.Accessibility).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                openAccessibility();
            }
        });

        findViewById((R.id.SavePaletteEditor)).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                Toast.makeText(context, text, duration).show();
            }
        });

        addColor.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                openAddColor();
            }
        });

        exitBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                builder.setCancelable(true);
                builder.setTitle("Paleta");
                builder.setMessage("Do you want to save before you exit?");
                builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        returnToHome();
                    }
                });
                builder.setNegativeButton("Don't Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        returnToHome();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();


            }
        });

        color1.setOnClickListener(
        new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                new ColorPickerPopup.Builder(PaletteEditorActivity.this)
                        .initialColor(Color.RED) // Set initial color
                        .enableBrightness(true) // Enable brightness slider or not
                        .enableAlpha(true) // Enable alpha slider or not
                        .okTitle("Choose")
                        .cancelTitle("Cancel")
                        .showIndicator(true)
                        .showValue(true)
                        .build()
                        .show(v, new ColorPickerPopup.ColorPickerObserver() {
                            @Override
                            public void onColorPicked(int color) {
                                mColor = color;
                                color1.setBackgroundColor(mColor);
                                if(savedColors.size()>=1){
                                    db.updateSavedColor(color, rids.get(0));
                                }else{
                                    db.insertSavedColors(color, pid);
                                }
                            }
                        });
            }
        }
);

color2.setOnClickListener(
        new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                new ColorPickerPopup.Builder(PaletteEditorActivity.this)
                        .initialColor(Color.RED) // Set initial color
                        .enableBrightness(true) // Enable brightness slider or not
                        .enableAlpha(true) // Enable alpha slider or not
                        .okTitle("Choose")
                        .cancelTitle("Cancel")
                        .showIndicator(true)
                        .showValue(true)
                        .build()
                        .show(v, new ColorPickerPopup.ColorPickerObserver() {
                            @Override
                            public void onColorPicked(int color) {
                                mColor = color;
                                color2.setBackgroundColor(mColor);
                                if(savedColors.size()>=2){
                                    db.updateSavedColor(color, rids.get(1));
                                }else{
                                    db.insertSavedColors(color, pid);
                                }
                            }
                        });
            }
        }
);

color3.setOnClickListener(
        new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                new ColorPickerPopup.Builder(PaletteEditorActivity.this)
                        .initialColor(Color.RED) // Set initial color
                        .enableBrightness(true) // Enable brightness slider or not
                        .enableAlpha(true) // Enable alpha slider or not
                        .okTitle("Choose")
                        .cancelTitle("Cancel")
                        .showIndicator(true)
                        .showValue(true)
                        .build()
                        .show(v, new ColorPickerPopup.ColorPickerObserver() {
                            @Override
                            public void onColorPicked(int color) {
                                mColor = color;
                                color3.setBackgroundColor(mColor);
                                if(savedColors.size()>=3){
                                    db.updateSavedColor(color, rids.get(2));
                                }else{
                                    db.insertSavedColors(color, pid);
                                }
                            }
                        });
            }
        }
);

color4.setOnClickListener(
        new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                new ColorPickerPopup.Builder(PaletteEditorActivity.this)
                        .initialColor(Color.RED) // Set initial color
                        .enableBrightness(true) // Enable brightness slider or not
                        .enableAlpha(true) // Enable alpha slider or not
                        .okTitle("Choose")
                        .cancelTitle("Cancel")
                        .showIndicator(true)
                        .showValue(true)
                        .build()
                        .show(v, new ColorPickerPopup.ColorPickerObserver() {
                            @Override
                            public void onColorPicked(int color) {
                                mColor = color;
                                color4.setBackgroundColor(mColor);
                                if(savedColors.size()>=4){
                                    db.updateSavedColor(color, rids.get(3));
                                }else{
                                    db.insertSavedColors(color, pid);
                                }
                            }
                        });
            }
        }
);

color5.setOnClickListener(
        new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                new ColorPickerPopup.Builder(PaletteEditorActivity.this)
                        .initialColor(Color.RED) // Set initial color
                        .enableBrightness(true) // Enable brightness slider or not
                        .enableAlpha(true) // Enable alpha slider or not
                        .okTitle("Choose")
                        .cancelTitle("Cancel")
                        .showIndicator(true)
                        .showValue(true)
                        .build()
                        .show(v, new ColorPickerPopup.ColorPickerObserver() {
                            @Override
                            public void onColorPicked(int color) {
                                mColor = color;
                                color5.setBackgroundColor(mColor);
                                if(savedColors.size()>=5){
                                    db.updateSavedColor(color, rids.get(4));
                                }else{
                                    db.insertSavedColors(color, pid);
                                }
                            }
                        });
            }
        }
);

color6.setOnClickListener(
        new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                new ColorPickerPopup.Builder(PaletteEditorActivity.this)
                        .initialColor(Color.RED) // Set initial color
                        .enableBrightness(true) // Enable brightness slider or not
                        .enableAlpha(true) // Enable alpha slider or not
                        .okTitle("Choose")
                        .cancelTitle("Cancel")
                        .showIndicator(true)
                        .showValue(true)
                        .build()
                        .show(v, new ColorPickerPopup.ColorPickerObserver() {
                            @Override
                            public void onColorPicked(int color) {
                                mColor = color;
                                color6.setBackgroundColor(mColor);
                                if(savedColors.size()>=6){
                                    db.updateSavedColor(color, rids.get(5));
                                }else{
                                    db.insertSavedColors(color, pid);
                                }
                            }
                        });
            }
        }
);

color7.setOnClickListener(
        new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                new ColorPickerPopup.Builder(PaletteEditorActivity.this)
                        .initialColor(Color.RED) // Set initial color
                        .enableBrightness(true) // Enable brightness slider or not
                        .enableAlpha(true) // Enable alpha slider or not
                        .okTitle("Choose")
                        .cancelTitle("Cancel")
                        .showIndicator(true)
                        .showValue(true)
                        .build()
                        .show(v, new ColorPickerPopup.ColorPickerObserver() {
                            @Override
                            public void onColorPicked(int color) {
                                mColor = color;
                                color7.setBackgroundColor(mColor);
                                if(savedColors.size()>=7){
                                    db.updateSavedColor(color, rids.get(6));
                                }else{
                                    db.insertSavedColors(color, pid);
                                }
                            }
                        });
            }
        }
);

color8.setOnClickListener(
        new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                new ColorPickerPopup.Builder(PaletteEditorActivity.this)
                        .initialColor(Color.RED) // Set initial color
                        .enableBrightness(true) // Enable brightness slider or not
                        .enableAlpha(true) // Enable alpha slider or not
                        .okTitle("Choose")
                        .cancelTitle("Cancel")
                        .showIndicator(true)
                        .showValue(true)
                        .build()
                        .show(v, new ColorPickerPopup.ColorPickerObserver() {
                            @Override
                            public void onColorPicked(int color) {
                                mColor = color;
                                color8.setBackgroundColor(mColor);
                                if(savedColors.size()>=8){
                                    db.updateSavedColor(color, rids.get(7));
                                }else{
                                    db.insertSavedColors(color, pid);
                                }
                            }
                        });
            }
        }
);

        Button bExport = findViewById(R.id.Export);

        bExport.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openEmailExport();
                    }
                }
        );



    }



    public void openAddColor(){
        Intent intent = new Intent( this, AddColor.class );
        startActivity( intent );
    }

    public void returnToHome(){
        Intent intent = new Intent( this, MainActivity.class );
        startActivity( intent );
    }

    public void openAccessibility(){
        Intent intent = new Intent( this, AccessibilityActivity.class );
        startActivity( intent );
    }

    public void openExport() {

        String output = "This is placeholder text.  We will add color values and format accordingly later on.";
        Intent sendIntent = new Intent();
        sendIntent.setAction( Intent.ACTION_SEND );
        sendIntent.putExtra( Intent.EXTRA_TEXT, output );

        Intent shareIntent = Intent.createChooser( sendIntent, null );
        startActivity( shareIntent );
    }

    public void openEmailExport() {

        String output = "Color 1: #22e8f2 \nColor 2: #e8b254 \nColor 3: #eb215a \nColor 4: #036b6b \nColor 5: #66bda4 \nColor 6:  \nColor 7:  \nColor 8:  \n";

        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"recipient@example.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "Paleta");
        i.putExtra(Intent.EXTRA_TEXT   , output );
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(PaletteEditorActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }
}