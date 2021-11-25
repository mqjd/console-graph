package org.mqjd.graphics;

import org.mqjd.common.Color;
import org.mqjd.common.Point;
import org.mqjd.utils.StringUtil;

public class Text {
    private final Point point;
    private final String text;
    private final Color color;

    public Text(Point point, String text, Color color) {
        this.color = color;
        this.point = point;
        this.text = text;
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

    public int getPosition() {
        return getPoint().getX();
    }

    public int getLength() {
        return StringUtil.getStringWidth(text);
    }

    public Text cut(int length) {
        int cutLength = 0;
        for (int i = text.length(); i > 0; i--) {
            cutLength += StringUtil.getStringWidth(String.valueOf(text.charAt(i - 1)));
            int space = cutLength - length;
            if (space >= 0) {
                String newText = text.substring(0, i - 1);
                return new Text(point, space == 1 ? newText + " " : newText, color);
            }
        }
        return new Text(point, text, color);
    }
}
