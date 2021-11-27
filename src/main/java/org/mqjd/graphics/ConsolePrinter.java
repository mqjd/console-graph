package org.mqjd.graphics;

import java.util.HashMap;
import java.util.Map;

import org.mqjd.common.BoundingRect;
import org.mqjd.element.Drawer;
import org.mqjd.element.Text;

public class ConsolePrinter implements Drawer {

    private final Map<Integer, ConsoleLine> lines = new HashMap<>();
    private int maxRows = 0;
    private final Graphics graphics;

    public ConsolePrinter(Graphics graphics) {
        this.graphics = graphics;
    }

    @Override
    public void draw() {
        for (int i = 1; i <= maxRows; i++) {
            lines.compute(i, (key, value) -> {
                if (value != null) {
                    value.draw();
                } else {
                    ConsoleLine.drawEmpty();
                }
                return value;
            });
        }
    }

    public void add(Text text) {
        BoundingRect boundingRect = text.getBoundingRect();
        lines.compute(boundingRect.getY(), (k, v) -> {
            ConsoleLine consoleLine = v;
            if (consoleLine == null) {
                consoleLine = new ConsoleLine(graphics);
            }
            consoleLine.add(text);
            return consoleLine;
        });
        maxRows = Math.max(maxRows, boundingRect.getY());
    }
}
