package ru.gr0946x.ui.painting.colors;

import java.awt.*;

import static java.lang.Math.*;

public class ColorSchemes {
    public static Color colorScheme1(float x) {
        if (x == 1f) return Color.BLACK;
        var r = (float)abs(sin(5 * x));
        var g = (float)abs(cos(8 * x * x));
        var b = (float)max(0, min(log(abs(sin(10*x)*cos(4*x))+0.01), 1));
        return new Color(r, g, b);
    }

    public static Color colorScheme2(float x) {
        if (x == 1f) return Color.BLACK;
        var r = (float)abs(cos(8 * x * x));
        var g = (float)abs(sin(5 * x));
        var b = (float)max(0, min(log(abs(sin(10*x)*cos(4*x))+0.01), 1));
        return new Color(r, g, b);
    }

    public static Color colorScheme3(float x) {
        if (x == 1f) return Color.BLACK;
        var r = (float)max(0, min(log(abs(sin(10*x)*cos(4*x))+0.01), 1));
        var g = (float)abs(cos(8 * x * x));
        var b = (float)abs(sin(5 * x));
        return new Color(r, g, b);
    }

    public static Color colorScheme4(float x) {
        if (x == 1f) return Color.BLACK;
        var r = (float)abs(sin(5 * x));
        var g = (float)max(0, min(log(abs(sin(10*x)*cos(4*x))+0.01), 1));
        var b = (float)abs(cos(8 * x * x));
        return new Color(r, g, b);
    }

}
