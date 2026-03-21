package ru.gr0946x.fractals;

import ru.smak.math.Complex;

public class Mandelbrot implements Fractal{

    private int maxIter;
    private double r2 = 4.0;

    public int getMaxIter() {
        return maxIter;
    }

    public void setMaxIter(int maxIter) {
        this.maxIter = Math.max(1, maxIter);
    }

    public double getR() {
        return Math.sqrt(r2);
    }

    public void setR(double r) {
        this.r2 = r * r;
    }

    public Mandelbrot(int maxIter, double r){
        setMaxIter(maxIter);
        setR(r);
    }
    @Override
    public float inSetProbability(double x, double y) {
        var c = new Complex(x, y);
        int iter = 0;
        var z = new Complex();
        while (iter < maxIter && z.getAbsoluteValue2() < r2){
            z.timesAssign(z);
            z.plusAssign(c);
            iter++;
        }
        return (float)iter / maxIter;
    }
}
