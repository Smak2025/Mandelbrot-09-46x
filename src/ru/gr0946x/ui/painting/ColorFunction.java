package ru.gr0946x.ui.painting;

import java.awt.*;

@FunctionalInterface
public interface ColorFunction {
    Color get(float value);
}