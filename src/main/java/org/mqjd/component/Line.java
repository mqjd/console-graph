package org.mqjd.component;

import org.mqjd.common.Color;
import org.mqjd.common.LineStyle;
import org.mqjd.graphics.Graphics;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line implements Component {
    private final int length;
    private final Graphics graphics;
    private final LineStyle lineStyle;
    private final Color color;

    public Line(Graphics graphics, int length, LineStyle position, Color color) {
        this.graphics = graphics;
        this.length = length;
        this.lineStyle = position;
        this.color = color;
    }

    public Line(Graphics graphics, int length) {
        this.graphics = graphics;
        this.length = length;
        this.lineStyle = LineStyle.MIDDLE_SINGLE;
        this.color = Color.WHITE;
    }

    @Override
    public void draw() {
        graphics.draw(IntStream.range(0, length + 1)
                        .mapToObj(v -> "")
                        .collect(Collectors.joining(lineStyle.getText())),
                color.getColor());
    }

}
