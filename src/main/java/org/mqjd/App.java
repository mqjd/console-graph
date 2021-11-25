package org.mqjd;

import org.mqjd.common.Color;
import org.mqjd.common.LineStyle;
import org.mqjd.common.Point;
import org.mqjd.common.Size;
import org.mqjd.component.Line;
import org.mqjd.component.Rect;
import org.mqjd.graphics.Graphics;

/**
 * App
 */
public class App {
    public static void main(String[] args) {
        Graphics graphics = new Graphics();
        graphics
                .add(new Rect(graphics, Size.of(10, 4), Point.of(3, 4)))
                .add(new Rect(graphics, Size.of(10, 4), Point.of(10, 6)))
                .draw();
    }
}
