package org.mqjd;

import org.mqjd.common.Point;
import org.mqjd.common.Size;
import org.mqjd.element.Rect;
import org.mqjd.graphics.Graphics;

/**
 * App
 */
public class App {
    public static void main(String[] args) {
        Graphics graphics = new Graphics();
        graphics.add(new Rect(graphics, Point.of(10, 2), Size.of(10, 4)))
                .add(new Rect(graphics, Point.of(14, 4), Size.of(10, 4)))
                .add(new Rect(graphics, Point.of(16, 6), Size.of(10, 4)))
                .add(new Rect(graphics, Point.of(18, 8), Size.of(10, 4)))
                .add(new Rect(graphics, Point.of(22, 4), Size.of(10, 4)))
                .add(new Rect(graphics, Point.of(22, 6), Size.of(10, 4)))
                .draw();
    }
}
