package org.mqjd.component;

import org.mqjd.common.BorderStyle;
import org.mqjd.common.Color;
import org.mqjd.common.Point;
import org.mqjd.common.Size;
import org.mqjd.graphics.Graphics;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Rect implements Component {
    private final Graphics graphics;
    private final Size size;
    private final Point point;
    private final BorderStyle borderStyle;
    private final Color color;

    public Rect(Graphics graphics, Size size, Point point) {
        this.graphics = graphics;
        this.size = size;
        this.point = point;
        this.borderStyle = BorderStyle.SINGLE_LINE;
        this.color = Color.WHITE;
    }

    public Rect(Graphics graphics, Size size, Point point, BorderStyle borderStyle, Color color) {
        this.graphics = graphics;
        this.size = size;
        this.point = point;
        this.borderStyle = borderStyle;
        this.color = color;
    }

    @Override
    public void draw() {
        String topEdge = String.format("%s%s%s", borderStyle.getNorthwest(), IntStream.range(0, size.getWidth() - 1)
            .mapToObj(v -> "").collect(Collectors.joining(borderStyle.getHorizontal())), borderStyle.getNortheast());
        graphics.draw(point,topEdge, color);
    }
}
