package com.example.paleta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.palette.graphics.Palette;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.IOException;

public class GalleryOrCameraActivity extends AppCompatActivity {

    private static final int PICK_IMAGE = 1;
    Uri imageUri;
    Button bCP;
    ImageButton exitGallery;
    ImageDBHelper convertImage = new ImageDBHelper();
    byte[] image;
    DBHelper db;
    ImageView imageSquare;
    Bitmap bitmap2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_or_camera);
        db = new DBHelper(this);

        bCP = findViewById(R.id.button2);
        imageSquare = findViewById(R.id.imageReview);
        exitGallery = findViewById(R.id.ExitPaletteEditor);
        bCP.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                //openGallery();
                Intent gallery = new Intent();
                gallery.setType("image/*");
                gallery.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(gallery, "Select Picture"), PICK_IMAGE);
                //openReview();
            }
        });

        findViewById(R.id.Continue).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                bitmap2 = ((BitmapDrawable) imageSquare.getDrawable()).getBitmap();
                /*try {
                    image = convertImage.getBytes(bitmap2);
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
                Palette p = createPaletteSync(bitmap2);
                Integer pid = db.insertPaletteData("Palette1");
                OurPalette palette = new OurPalette(p);
                db.insertSavedColors(palette.getSavedColor(0), pid);
                db.insertSavedColors(palette.getSavedColor(1), pid);
                db.insertSavedColors(palette.getSavedColor(2), pid);
                db.insertSavedColors(palette.getSavedColor(3), pid);
                db.setCurrentPalette(pid);
                //db.insertImageData(pid, image);
                int i = 0;
                while(i<10){
                    db.insertAllColors(palette.getAnAllColor(i),pid);
                    i++;
                }

                acceptImage();

            }
        });



    }



    public Palette createPaletteSync(Bitmap bitmap) {
        Palette p = Palette.from(bitmap).generate();
        return p;
    }

    public void openGallery(){
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(intent,PICK_IMAGE);
    }

    public void acceptImage(){
        Intent intent = new Intent( this, PaletteEditorActivity.class );
        startActivity( intent );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK && requestCode==PICK_IMAGE){
            imageUri = data.getData();
            try{
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                imageSquare.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}