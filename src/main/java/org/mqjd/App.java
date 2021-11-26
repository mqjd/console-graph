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
        graphics.add(new Rect(graphics, Point.of(10, 6), Size.of(10, 4)))
            .add(new Rect(graphics, Point.of(18, 6), Size.of(10, 4))).draw();
    }
}
