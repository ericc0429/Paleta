package com.example.paleta;

import android.graphics.Color;
import android.graphics.ColorSpace;
import android.os.Build;

import androidx.annotation.RequiresApi;

//import java.awt.Color;


public final class ContrastChecker {
    /* */

    private final double RED_factor = 0.2126;
    /* */
    private final double GREEN_factor = 0.7152;
    /* */
    private final double BLUE_factor = 0.0722;
    /* */
    private final double CONTRAST_factor = 0.05;
    /* */
    private final double RGB_MAX_VALUE = 255;
    /* */
    private final double RSGB_factor = 0.03928;
    /* */
    private final double LUMINANCE_INF = 12.92;
    /* */
    private final double LUMINANCE_SUP_CONST = 0.055;
    /* */
    private final double LUMINANCE_SUP_CONST2 = 1.055;
    /* */
    private final double LUMINANCE_EXP = 2.4;
    /* */
    private final int ROUND_VALUE = 100000;


    ContrastChecker() {
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public double distanceColor(final Color fgColor, final Color bgColor) {
        float redFg = fgColor.red();
        float redBg = bgColor.red();
        float greenBg = bgColor.green();
        float greenFg = fgColor.green();
        float blueFg = fgColor.blue();
        float blueBg = bgColor.blue();
        return (Math.sqrt(Math.pow(redFg - redBg, 2) + Math.pow(greenFg - greenBg, 2) + Math.pow(blueFg - blueBg, 2)));
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public String getConstrastRatio_new(Integer rgb1, Integer rgb2) {
        Color fgColor = Color.valueOf(rgb1);
        Color bgColor = Color.valueOf(rgb2);
        double fgLuminosity = getLuminosity(fgColor);
        double bgLuminosity = getLuminosity(bgColor);
        if (fgLuminosity > bgLuminosity) {
            double a = computeContrast(fgLuminosity, bgLuminosity);
            String ratio_part_1 = Double.toString(a);
            String ratio_1= Integer.toString((int) a);
            String ratio_part_2 = ":";
            String ratio_part_3 = "1";
            String ratio = ratio_1 +ratio_part_2+ratio_part_3;
            return ratio;

        } else {
            double a = computeContrast(bgLuminosity, fgLuminosity);
            String ratio_part_1 = Double.toString(a);
            String ratio_1= Integer.toString((int) a);
            String ratio_part_2 = ":";
            String ratio_part_3 = "1";
            String ratio = ratio_1 +ratio_part_2+ratio_part_3;
            return ratio;
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public Boolean isContrastValid(int rgbFg, int rgbBg, Float coefficientLevel) {
        return getConstrastRatio(rgbFg, rgbBg) > coefficientLevel;
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public double getConstrastRatio(int rgbFg, int rgbBg) {
        Color fgColor = Color.valueOf(rgbFg);
        Color bgColor = Color.valueOf(rgbBg);
        //double fgLuminosity1 = fgColor.red()*0.2126 + fgColor.green()*0.7152 + fgColor.blue()*0.0722;
        //double bgLuminosity1 = bgColor.red()*0.2126 + bgColor.green()*0.7152 + bgColor.blue()*0.0722;
        double fgLuminosity1 = getLuminosity(fgColor);
        double bgLuminosity1 = getLuminosity(bgColor);
        if (fgLuminosity1 > bgLuminosity1) {
            return Double.valueOf(((fgLuminosity1 + 0.05) / (bgLuminosity1 + 0.05)));
        } else {
            return Double.valueOf(((bgLuminosity1 + 0.05) / (fgLuminosity1 + 0.05)));
        }
    }


    private double computeContrast(double lighter, double darker) {
        return (Double.valueOf(((lighter + CONTRAST_factor) / (darker + CONTRAST_factor))));
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public double getLuminosity(Color color) {
        double luminosity =
                getComposantValue(color.red()) * RED_factor
                        + getComposantValue(color.green()) * GREEN_factor
                        + getComposantValue(color.blue()) * BLUE_factor;

        return luminosity;
    }


    private double getComposantValue(float composant) {
        double rsgb = composant / RGB_MAX_VALUE;
        if (rsgb <= RSGB_factor) {
            return rsgb / LUMINANCE_INF;
        } else {
            return Math.pow(((rsgb + LUMINANCE_SUP_CONST) / LUMINANCE_SUP_CONST2), LUMINANCE_EXP);
        }
    }

    public String changeToHex(Integer intColor){
        String hexColor = String.format("#%06X", (0xFFFFFF & intColor));
        return  hexColor;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public int getGrayScale(int rgb) {
        Color color = Color.valueOf(rgb);
        //color.convert(rgb, ColorSpace.Rgb);
        float newRed = (color.red()+color.green()+color.blue())/3;
        //float newGreen = color.green()*59/100;
        //float newBlue = color.blue()*11/100;
        Color color1 = Color.valueOf(newRed, newRed, newRed);
        //double grayscale = (color.red())*30 + (color.blue())*11 + (color.green())*59;
        return color1.toArgb();
    }
}