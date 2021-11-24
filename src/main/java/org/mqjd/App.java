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
        graphics.add(new Line(graphics, 10, Point.of(0, 0)))
            .add(new Line(graphics, 10, Point.of(1, 1), LineStyle.MIDDLE_SINGLE, Color.RED))
            .add(new Line(graphics, 10, Point.of(1, 2), LineStyle.BOTTOM_SINGLE, Color.CYAN))
            .add(new Rect(graphics, Size.of(10, 10), Point.of(3, 4))).draw();
    }
}
