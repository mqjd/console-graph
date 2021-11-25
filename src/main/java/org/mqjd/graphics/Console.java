package org.mqjd.graphics;

import java.util.HashMap;
import java.util.Map;

import org.mqjd.component.Component;

public class Console implements Component {

    private final Map<Integer, ConsoleLine> lines = new HashMap<>();
    private int maxRows = 0;

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

    public void add(Text text) {

        lines.compute(text.getPoint().getY(), (k, v) -> {
            ConsoleLine consoleLine = v;
            if (consoleLine == null) {
                consoleLine = new ConsoleLine();
            }
            consoleLine.add(text);
            return consoleLine;
        });
        maxRows = Math.max(maxRows, text.getPoint().getY());
    }
}
