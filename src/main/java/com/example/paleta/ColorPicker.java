package com.example.paleta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.azeesoft.lib.colorpicker.ColorPickerDialog;

import top.defaults.colorpicker.ColorPickerPopup;

import android.os.Bundle;

public class ColorPicker extends AppCompatActivity {

    int amtFavs = 14;
    private View [] vFavColor = new View[amtFavs];
    private Button [] bFavColor = new Button[amtFavs];
    //private int [] mColor = new int[amtFavs];

    //private View vFavColor;
    //private Button bFavColor;
    private int mColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker);


        int [] resIDs = { R.id.FavColor1, R.id.FavColor2, R.id.FavColor3, R.id.FavColor4, R.id.FavColor5, R.id.FavColor6, R.id.FavColor7, R.id.FavColor8, R.id.FavColor9, R.id.FavColor10, R.id.FavColor11, R.id.FavColor12, R.id.FavColor13, R.id.FavColor14 };

        for ( int i = 0; i < amtFavs; i++ ) {
            vFavColor[i] = findViewById(resIDs[i]);
            bFavColor[i] = findViewById(resIDs[i]);
        }

        bFavColor[0].setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        new ColorPickerPopup.Builder(ColorPicker.this)
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
                                        vFavColor[0].setBackgroundColor(mColor);
                                    }
                                });
                    }
                }
        );

        bFavColor[1].setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        new ColorPickerPopup.Builder(ColorPicker.this)
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
                                        vFavColor[1].setBackgroundColor(mColor);
                                    }
                                });
                    }
                }
        );

        bFavColor[2].setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        new ColorPickerPopup.Builder(ColorPicker.this)
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
                                        vFavColor[2].setBackgroundColor(mColor);
                                    }
                                });
                    }
                }
        );

        bFavColor[3].setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        new ColorPickerPopup.Builder(ColorPicker.this)
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
                                        vFavColor[3].setBackgroundColor(mColor);
                                    }
                                });
                    }
                }
        );

        bFavColor[4].setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        new ColorPickerPopup.Builder(ColorPicker.this)
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
                                        vFavColor[4].setBackgroundColor(mColor);
                                    }
                                });
                    }
                }
        );

        bFavColor[5].setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        new ColorPickerPopup.Builder(ColorPicker.this)
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
                                        vFavColor[5].setBackgroundColor(mColor);
                                    }
                                });
                    }
                }
        );

        bFavColor[6].setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        new ColorPickerPopup.Builder(ColorPicker.this)
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
                                        vFavColor[6].setBackgroundColor(mColor);
                                    }
                                });
                    }
                }
        );

        bFavColor[7].setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        new ColorPickerPopup.Builder(ColorPicker.this)
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
                                        vFavColor[7].setBackgroundColor(mColor);
                                    }
                                });
                    }
                }
        );

        bFavColor[8].setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        new ColorPickerPopup.Builder(ColorPicker.this)
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
                                        vFavColor[8].setBackgroundColor(mColor);
                                    }
                                });
                    }
                }
        );

        bFavColor[9].setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        new ColorPickerPopup.Builder(ColorPicker.this)
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
                                        vFavColor[9].setBackgroundColor(mColor);
                                    }
                                });
                    }
                }
        );

        bFavColor[10].setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        new ColorPickerPopup.Builder(ColorPicker.this)
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
                                        vFavColor[10].setBackgroundColor(mColor);
                                    }
                                });
                    }
                }
        );

        bFavColor[11].setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        new ColorPickerPopup.Builder(ColorPicker.this)
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
                                        vFavColor[11].setBackgroundColor(mColor);
                                    }
                                });
                    }
                }
        );

        bFavColor[12].setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        new ColorPickerPopup.Builder(ColorPicker.this)
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
                                        vFavColor[12].setBackgroundColor(mColor);
                                    }
                                });
                    }
                }
        );

        bFavColor[13].setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        new ColorPickerPopup.Builder(ColorPicker.this)
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
                                        vFavColor[13].setBackgroundColor(mColor);
                                    }
                                });
                    }
                }
        );

        /* NOT WORKING
        addFav = (Button) findViewById(R.id.AddToFavorites);
        addFav.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                openAddFav(mColor);
            }
        });
         */

/*
        new ColorPickerPopup.Builder(this)
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
                        v.setBackgroundColor(color);
                    }
                    @Override
                    public void onColor(int color, boolean fromUser) {
                    }
                });
 */

    }

    /* NOT WORKING
    // Open Color Picker Method
    public void openAddFav( int mColor ) {
        vFavColor1.setBackgroundColor(mColor);
    }
    */
}