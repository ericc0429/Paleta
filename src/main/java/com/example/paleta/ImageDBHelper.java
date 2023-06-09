package com.example.paleta;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ImageDBHelper {

    public ImageDBHelper(){

    }

    // convert from bitmap to byte array
    public byte[] getBytes(Bitmap bitmap) throws IOException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
        stream.close();
        return stream.toByteArray();
    }

    // convert from byte array to bitmap
    public Bitmap getImage(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }
}
