package org.mqjd.element;

import org.mqjd.common.BoundingRect;
import org.mqjd.common.Color;
import org.mqjd.common.Point;
import org.mqjd.common.Size;
import org.mqjd.graphics.Graphics;
import org.mqjd.utils.StringUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Text implements Element {
    private final Graphics graphics;
    private final Point point;
    private final String text;
    private final Color color;
    private final int length;

    public Text(Graphics graphics, Point point, String text, Color color) {
        this.graphics = graphics;
        this.point = point;
        this.text = text;
        this.color = color;
        this.length = StringUtil.getStringWidth(text);
    }

    public int getPosition() {
        return point.getX();
    }

    @Override
    public void draw() {
        graphics.draw(this);
    }

    public int getLength() {
        return length;
    }

    public Graphics getGraphics() {
        return graphics;
    }

    public Point getPoint() {
        return point;
    }

    public String getText() {
        return text;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public BoundingRect getBoundingRect() {
        return new BoundingRect(point, Size.of(StringUtil.getStringWidth(text), 1));
    }

    public boolean mixable(Element element) {
        return false;
    }

    public Border mix(Element element) {
        throw new IllegalArgumentException("Text can not mix other element");
    }

    public Text cut(int length) {
        int cutLength = 0;
        for (int i = text.length(); i > 0; i--) {
            cutLength += StringUtil.getStringWidth(String.valueOf(text.charAt(i - 1)));
            int space = cutLength - length;
            if (space >= 0) {
                String newText = text.substring(0, i - 1);
                return new Text(graphics, point, space == 1 ? newText + " " : newText, color);
            }
        }
        return new Text(graphics, point, text, color);
    }

}
