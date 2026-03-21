package ru.gr0946x.ui;

import ru.gr0946x.ui.painting.Painter;
import javax.swing.*;
import java.awt.*;

public class PaintPanel extends JPanel {

    private final Painter p;
    public PaintPanel(Painter painter){
        this.p = painter;
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        p.paint(g);
    }
}
