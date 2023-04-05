package com.example.paleta;

import androidx.palette.graphics.Palette;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OurPalette {

    String name;
    Date createdDate;
    Date lastModified;
    List<Palette.Swatch> allSwatches = new ArrayList<>(16);
    List<Integer> savedSwatches = new ArrayList<>(16);
    ArrayList<Integer> allColors = new ArrayList<>();

    public OurPalette(Palette palette){
        allSwatches = palette.getSwatches();
        savedSwatches.add(palette.getMutedColor(1));
        savedSwatches.add(palette.getLightVibrantColor(1));
        savedSwatches.add(palette.getVibrantColor(1));
        savedSwatches.add(palette.getDarkMutedColor(1));

        allColors.add(palette.getDominantColor(1));
        allColors.add(palette.getLightVibrantColor(1));
        allColors.add(palette.getVibrantColor(1));
        allColors.add(palette.getMutedColor(1));

        allColors.add(palette.getMutedColor(15));
        allColors.add(palette.getVibrantColor(15));
        allColors.add(palette.getLightVibrantColor(15));
        allColors.add(palette.getDominantColor(15));
        allColors.add(palette.getDarkMutedColor(2));
        allColors.add(palette.getLightMutedColor(2));

    }

    public void addColor(Integer color){
        savedSwatches.add(color);

    }

    public ArrayList<Integer> getAllColors(){return allColors;}
    public Integer getAnAllColor(int number){
        return allColors.get(number);
    }
    public Integer getSavedColor(int number){
        return savedSwatches.get(number);
    }

    public void changeName(String newName){
        this.name = newName;
    }

    public void updateDateModified(Date newDate){
        lastModified = newDate;
    }
}
