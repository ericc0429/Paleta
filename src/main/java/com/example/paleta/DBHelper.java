package com.example.paleta;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "PaletteData.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table Palettedetails(pid integer primary key,name TEXT)");
        db.execSQL("create Table PaletteSavedColors(rid integer primary key, pid integer,  rgb integer, foreign key (pid) references Palettedetails (pid))");
        db.execSQL("create Table PaletteAllColors(aid integer primary key, pid integer, rgb integer, foreign key (pid) references Palettedetails (pid))");
        db.execSQL("create Table CurrentPalette(pid Integer)");
        db.execSQL("create Table CurrentColor(rid integer)");
        db.execSQL("create Table CurrentImage(image blob)");
        db.execSQL("create Table ImagesTable(pid integer, image blob)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists Palettedetails");
        db.execSQL("drop Table if exists PaletteSavedColors");
        db.execSQL("drop Table if exists PaletteAllColors");
        db.execSQL("drop Table if exists CurrentPalette");
        db.execSQL("drop Table if exists CurrentColor");
        db.execSQL("drop Table if exists ImagesTable");
        db.execSQL("drop Table if exists CurrentImage");
    }

    public Integer insertPaletteData(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        long result = db.insert("Palettedetails", null, contentValues);
        Cursor mCursor = db.rawQuery("SELECT *  FROM  Palettedetails", null);
        mCursor.moveToLast();
        Integer pid = mCursor.getInt(0);
        return pid;

    }

    public void insertImageData(Integer pid, byte[] image) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("pid", pid);
        contentValues.put("image", image);
        long result = db.insert("ImagesTable", null, contentValues);


    }

    public Boolean insertSavedColors(Integer rgb, Integer pid) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("pid", pid);
        //contentValues.put("name", name);
        contentValues.put("rgb", rgb);
        long result = db.insert("PaletteSavedColors", null, contentValues);
        if(result==1){
            return false;
        }else{
            return true;
        }
    }

    public Boolean insertAllColors(Integer rgb, Integer pid) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("pid", pid);
        //contentValues.put("name", name);
        contentValues.put("rgb", rgb);
        long result = db.insert("PaletteAllColors", null, contentValues);
        if(result==1){
            return false;
        }else{
            return true;
        }
    }

    public Boolean updatePaletteData(String name, Integer pid) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        Cursor cursor = db.rawQuery("Select * from Palettedetails where pid = ?", new String[]{String.valueOf(pid)});
        if(cursor.getCount()>0) {


            long result = db.update("Palettedetails", contentValues, "pid=?", new String[]{String.valueOf(pid)});

            if (result == 1) {
                return false;
            } else {
                return true;
            }
        }else{
            return false;
        }
    }

    public Boolean updateSavedColor(Integer rgb, Integer rid) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put("rid", rid);
        //contentValues.put("name", name);
        contentValues.put("rgb", rgb);
        Cursor cursor = db.rawQuery("Select * from PaletteSavedColors where rid = ?", new String[]{String.valueOf(rid)});

        if(cursor.getCount()>0) {


            long result = db.update("PaletteSavedColors", contentValues, "rid=?", new String[]{String.valueOf(rid)});

            if (result == 1) {
                return false;
            } else {
                return true;
            }
        }else{
            return false;
        }
    }

    public Boolean deletePaletteData(Integer pid) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("Select * from Palettedetails where pid = ?", new String[]{String.valueOf(pid)});
        if(cursor.getCount()>0) {
            long result = db.delete("Palettedetails", "pid=?", new String[]{String.valueOf(pid)});
            if (result == 1) {
                return false;
            } else {
                return true;
            }
        }else{
            return false;
        }
    }

    public void deleteSavedPalette(Integer pid){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("Select * from PaletteSavedColors where pid = ?", new String[]{String.valueOf(pid)});
        if(cursor.getCount()>0) {
            long result = db.delete("PaletteSavedColors", "pid=?", new String[]{String.valueOf(pid)});
        }
    }

    public void deleteAllColorsPalette(Integer pid){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("Select * from PaletteAllColors where pid = ?", new String[]{String.valueOf(pid)});
        if(cursor.getCount()>0) {
            long result = db.delete("PaletteAllColors", "pid=?", new String[]{String.valueOf(pid)});
        }
    }


    public Boolean deleteSavedColor(Integer rid) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("Select * from PaletteSavedColors where rid = ?", new String[]{String.valueOf(rid)});
        if(cursor.getCount()>0) {
            long result = db.delete("PaletteSavedColors", "rid=?", new String[]{String.valueOf(rid)});
            if (result == 1) {
                return false;
            } else {
                return true;
            }
        }else{
            return false;
        }
    }

    public Boolean deleteImage(Integer pid) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("Select * from ImagesTable where pid = ?", new String[]{String.valueOf(pid)});
        if(cursor.getCount()>0) {
            long result = db.delete("ImagesTable", "pid=?", new String[]{String.valueOf(pid)});
            if (result == 1) {
                return false;
            } else {
                return true;
            }
        }else{
            return false;
        }
    }

    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("Select * from Palettedetails", null);
        return cursor;
    }


    public ArrayList<Integer> getPids() {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<Integer> test = new ArrayList<>();
        Cursor cursor = db.rawQuery("Select * from Palettedetails", null);
        if (cursor.moveToFirst()) {
            do {
                test.add(cursor.getInt(cursor.getColumnIndex("pid")));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return test;
    }

    public ArrayList<Integer> getRids(Integer pid) {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<Integer> test = new ArrayList<>();
        Cursor cursor = db.rawQuery("Select * from PaletteSavedColors where pid=?", new String[]{String.valueOf(pid)});
        if (cursor.moveToFirst()) {
            do {
                test.add(cursor.getInt(cursor.getColumnIndex("rid")));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return test;
    }

    public ArrayList<Integer> getSavedColors(Integer pid) {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<Integer> test = new ArrayList<>();
        Cursor cursor = db.rawQuery("Select * from PaletteSavedColors where pid=?", new String[]{String.valueOf(pid)});
        if (cursor.moveToFirst()) {
            do {
                test.add(cursor.getInt(cursor.getColumnIndex("rgb")));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return test;
    }

    public ArrayList<Integer> getAllColors(Integer pid) {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<Integer> test = new ArrayList<>();
        Cursor cursor = db.rawQuery("Select * from PaletteAllColors where pid=?", new String[]{String.valueOf(pid)});
        if (cursor.moveToFirst()) {
            do {
                test.add(cursor.getInt(cursor.getColumnIndex("rgb")));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return test;
    }

    //fix this
    public void setCurrentPalette(Integer pid) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("pid", pid);
        Cursor cursor = db.rawQuery("Select * from CurrentPalette where pid = ?", new String[]{String.valueOf(pid)});
        /*if(cursor.getCount()>0) {
            long result = db.update("CurrentPalette", contentValues, "pid=?", new String[]{String.valueOf(pid)});
        }else{*/
            long result2 = db.insert("CurrentPalette", null, contentValues);
        //}
    }

    public void setCurrentColor(Integer rid) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("rid", rid);
        Cursor cursor = db.rawQuery("Select * from CurrentColor where rid = ?", new String[]{String.valueOf(rid)});
        if(cursor.getCount()>0) {
            long result = db.update("CurrentColor", contentValues, "rid=?", new String[]{String.valueOf(rid)});
        }else{
            long result2 = db.insert("CurrentColor", null, contentValues);
        }
    }

    public void setCurrentImage( byte[] image){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new  ContentValues();
        cv.put("image",   image);
       /* Cursor cursor = db.rawQuery("Select * from CurrentImage where image = ?", new String[]{String.valueOf(image)});
        if(cursor.getCount()>0) {
            long result = db.update("CurrentPalette", cv, "image=?", new String[]{String.valueOf(image)});
        }else{*/
            long result2 = db.insert("CurrentPalette", null, cv);
        //}
    }

    public Integer getCurrentPalette(){
        SQLiteDatabase db = this.getWritableDatabase();
        Integer test = 0;
        Cursor cursor = db.rawQuery("Select * from CurrentPalette", null);
        if (cursor.moveToLast()) {
            test = cursor.getInt(cursor.getColumnIndex("pid"));
        }
        cursor.close();
        return test;
    }

    public Integer getCurrentColor(){
        SQLiteDatabase db = this.getWritableDatabase();
        Integer test = 0;
        Cursor cursor = db.rawQuery("Select * from CurrentColor", null);
        if (cursor.moveToFirst()) {
            test = cursor.getInt(cursor.getColumnIndex("rid"));
        }
        cursor.close();
        return test;
    }

    public byte[] getCurrentImage(){
        SQLiteDatabase db = this.getWritableDatabase();
        byte[] test = new byte[1080];
        Cursor cursor = db.rawQuery("Select * from CurrentImage", null);
        if (cursor.moveToLast()) {
            test = cursor.getBlob(cursor.getColumnIndex("image"));
        }
        cursor.close();
        return test;
    }

    public byte[] getAnImage(Integer pid){
        SQLiteDatabase db = this.getWritableDatabase();
        byte[] test = new byte[1080];
        Cursor cursor = db.rawQuery("Select * from ImagesTable where pid=?", new String[]{String.valueOf(pid)});
        test = cursor.getBlob(cursor.getColumnIndex("image"));

        cursor.close();
        return test;
    }


    public Integer getASavedColor( Integer rid){
        SQLiteDatabase db = this.getWritableDatabase();
        Integer test = 0;
        Cursor cursor = db.rawQuery("Select * from PaletteSavedColors where rid=?", new String[]{String.valueOf(rid)});
        if (cursor.moveToFirst()) {
            test = cursor.getInt(cursor.getColumnIndex("rgb"));
        }
        cursor.close();
        return test;
    }



    public void addImageEntry( Integer pid, byte[] image){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new  ContentValues();
        cv.put("pid", pid);
        cv.put("image",   image);
        long result = db.insert("ImageTable", null, cv);
        //Cursor mCursor = db.rawQuery("SELECT *  FROM  Palettedetails", null);
    }



}
