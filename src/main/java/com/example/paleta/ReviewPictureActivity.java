package com.example.paleta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.palette.graphics.Palette;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class ReviewPictureActivity extends AppCompatActivity {
    private Button bCP;
    private ImageView image;
    //List<OurPalette> newOurPalette = new ArrayList<OurPalette>(16);
    ImageView userPic;
    private Bitmap bitmap;
    DBHelper db;
    ImageDBHelper dbImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_picture);
        db = new DBHelper(this);
        byte[] byteImage = db.getCurrentImage();
        bitmap = dbImage.getImage(byteImage);
        // Palette Creation
        image = findViewById(R.id.image);
        image.setImageBitmap(bitmap);
        //bitmap =((BitmapDrawable) image.getDrawable()).getBitmap();
        bCP = (Button) findViewById(R.id.bCP);

        bCP.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                Palette p = createPaletteSync(bitmap);
                Integer pid = db.insertPaletteData("Palette1");
                OurPalette palette = new OurPalette(p);
                db.insertSavedColors(palette.getSavedColor(0), pid);
                db.insertSavedColors(palette.getSavedColor(1), pid);
                db.insertSavedColors(palette.getSavedColor(2), pid);
                db.insertSavedColors(palette.getSavedColor(3), pid);
                db.setCurrentPalette(pid);
                int i = 0;
                while(i<10){
                    db.insertAllColors(palette.getAnAllColor(i),pid);
                    i++;
                }
                openPE();

            }
        });
        findViewById(R.id.ExitReview).setOnClickListener( new View.OnClickListener() {@Override public void onClick( View v ) {
            returnToMain(); }
        });

    }

    // Links to Palette Editor Tool -- Consider passing a Palette class in with the saved color data.
    public void openPE(){
        Intent intent = new Intent( this, PaletteEditorActivity.class );
        startActivity( intent );
    }

    //Creates palette
    public Palette createPaletteSync(Bitmap bitmap) {
        Palette p = Palette.from(bitmap).generate();
        return p;
    }

    public void returnToMain(){
        Intent intent = new Intent( this, MainActivity.class );
        startActivity( intent );
    }
  /*  public void savePalette(OurPalette p){
        //Have to add shared preferences code and a global list instead of this one
        newOurPalette.add(p);
    }*/
}