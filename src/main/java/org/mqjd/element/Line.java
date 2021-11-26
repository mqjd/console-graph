package org.mqjd.element;

import org.mqjd.common.*;
import org.mqjd.graphics.Graphics;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line implements Element {
    private final int length;
    private final Graphics graphics;
    private final LineStyle lineStyle;
    private final Color color;
    private final Point point;

    public Line(Graphics graphics, int length, Point point) {
        this.graphics = graphics;
        this.length = length;
        this.point = point;
        this.lineStyle = LineStyle.MIDDLE_SINGLE;
        this.color = Color.WHITE;
    }

    public Line(Graphics graphics, int length, Point point, LineStyle lineStyle, Color color) {
        this.graphics = graphics;
        this.length = length;
        this.point = point;
        this.lineStyle = lineStyle;
        this.color = color;
    }

    @Override
    public void draw() {
        graphics.draw(new Text(graphics,point,
                IntStream.range(0, length).mapToObj(v -> lineStyle.getText()).collect(Collectors.joining()), color));
    }

    @Override
    public BoundingRect getBoundingRect() {
        return new BoundingRect(point, Size.of(length, 1));
    }

}
