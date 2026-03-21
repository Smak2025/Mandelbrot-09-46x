package ru.gr0946x.ui;

import ru.gr0946x.fractals.Mandelbrot;
import ru.gr0946x.ui.painting.FractalPainter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class MainWindow extends JFrame {

    private final PaintPanel mainPanel;
    private final Mandelbrot fractal;
    private final FractalPainter painter;

    public MainWindow(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(900, 650));
        fractal = new Mandelbrot(100, 2);
        painter = new FractalPainter(fractal);
        var conv = painter.getConverter();
        conv.setXShape(-2.0, 1.0);
        conv.setYShape(-1.0, 1.0);
        mainPanel = new PaintPanel(painter);
        mainPanel.setBackground(Color.WHITE);
        mainPanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                painter.setWidth(mainPanel.getWidth());
                painter.setHeight(mainPanel.getHeight());
            }
        });
        setContent();
    }

    private void setContent(){
        var gl = new GroupLayout(getContentPane());
        setLayout(gl);
        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGap(8)
                .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                .addGap(8)
        );
        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addGap(8)
                .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                .addGap(8)
        );
    }
}
