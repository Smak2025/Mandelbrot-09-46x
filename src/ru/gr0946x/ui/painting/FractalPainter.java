package ru.gr0946x.ui.painting;

import ru.gr0946x.Converter;
import ru.gr0946x.fractals.Fractal;

import java.awt.*;

public class FractalPainter implements Painter {
    private final Converter conv = new Converter(-1.0, 1.0, -1.0, 1.0);
    private final Fractal fractal;
    private ColorFunction color;

    @Override
    public int getWidth() {
        return conv.getWidth();
    }

    @Override
    public int getHeight() {
        return conv.getHeight();
    }

    @Override
    public void setWidth(int width) {
        conv.setWidth(width);
    }

    @Override
    public void setHeight(int height) {
        conv.setHeight(height);
    }

    public Converter getConverter(){
        return conv;
    }

    public FractalPainter(Fractal f){
        this.fractal = f;
        color = (v)->{
            if (v == 1.0)
                return Color.BLACK;
            else
                return Color.WHITE;
        };
    }

    public Fractal getFractalFunction(){
        return fractal;
    }

    public ColorFunction getColor() {
        return color;
    }

    public void setColor(ColorFunction color) {
        this.color = color;
    }

    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeight(); j++) {
                var x = conv.xScr2Crt(i);
                var y = conv.yScr2Crt(j);
                var fRes = fractal.inSetProbability(x, y);
                var clr = color.get(fRes);
                g.setColor(clr);
                g.drawLine(i, j, i + 1, j);
            }
        }
    }
}
