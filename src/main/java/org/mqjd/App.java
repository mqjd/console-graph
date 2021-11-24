package org.mqjd;

import org.mqjd.common.Color;
import org.mqjd.common.LineStyle;
import org.mqjd.component.Line;
import org.mqjd.graphics.Graphics;

/**
 * App
 */
public class App {
    public static void main(String[] args) {
        Graphics graphics = new Graphics();
        graphics.add(new Line(graphics,10))
                .add(new Line(graphics,10, LineStyle.MIDDLE_SINGLE, Color.RED))
                .add(new Line(graphics, 10, LineStyle.BOTTOM_SINGLE, Color.CYAN))
                .draw();
    }
}
