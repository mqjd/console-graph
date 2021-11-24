package org.mqjd.graphics;

import java.util.HashMap;
import java.util.Map;

import org.mqjd.common.Color;
import org.mqjd.common.Point;
import org.mqjd.component.Component;

public class Console implements Component {

    private final Map<Integer, ConsoleLine> lines = new HashMap<>();
    private int maxRows = 0;

    public void add(Point point, String text, Color color) {
        lines.compute(point.getY(), (k, v) -> {
            ConsoleLine consoleLine = v;
            if (consoleLine == null) {
                consoleLine = new ConsoleLine();
            }
            consoleLine.add(Text.of(point.getX(), text, color));
            return consoleLine;
        });
        maxRows = Math.max(maxRows, point.getY());
    }

    @Override
    public void draw() {
        for (int i = 0; i <= maxRows; i++) {
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
}
