package org.mqjd.graphics;

import org.mqjd.common.Color;

import java.util.Objects;

public class Text {

    private final String text;
    private final Color color;
    private final int position;
    private final int length;

    private Text(String text, Color color, int position, int length) {
        this.text = Objects.requireNonNull(text, "text cannot be null");
        this.color = Objects.requireNonNull(color, "color cannot be null");
        this.position = position;
        this.length = length;
    }

    public static Text of(int position, String text, Color color) {
        return new Text(text, color, position, text.length());
    }

    public String getText() {
        return text;
    }

    public Color getColor() {
        return color;
    }

    public int getLength() {
        return length;
    }

    public int getPosition() {
        return position;
    }
}
