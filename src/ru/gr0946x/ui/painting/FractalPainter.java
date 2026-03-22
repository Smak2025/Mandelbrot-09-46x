package ru.gr0946x.ui.painting;

import ru.gr0946x.Converter;
import ru.gr0946x.fractals.Fractal;
import ru.gr0946x.ui.painting.colors.ColorFunction;

import java.awt.*;

public class FractalPainter implements Painter {
    private final Converter converter;
    private final Fractal fractal;
    private ColorFunction color;

    @Override
    public int getWidth() {
        return converter.getWidth();
    }

    @Override
    public int getHeight() {
        return converter.getHeight();
    }

    @Override
    public void setWidth(int width) {
        converter.setWidth(width);
    }

    @Override
    public void setHeight(int height) {
        converter.setHeight(height);
    }

    public FractalPainter(
            Converter converter,
            Fractal fractal,
            ColorFunction colorFunction
    ) {
        this.fractal = fractal;
        this.converter = converter;
        color = colorFunction;
    }

    @Override
    public void paint(Graphics g) {
        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeight(); j++) {
                var x = converter.xScr2Crt(i);
                var y = converter.yScr2Crt(j);
                var fRes = fractal.inSetProbability(x, y);
                var clr = color.get(fRes);
                g.setColor(clr);
                g.drawLine(i, j, i + 1, j);
            }
        }
    }
}
