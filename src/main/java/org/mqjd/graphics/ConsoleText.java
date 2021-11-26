package org.mqjd.graphics;

import org.mqjd.common.Color;

public class ConsoleText {

    private final String text;
    private final Color color;

    public ConsoleText(String text, Color color) {
        this.text = text;
        this.color = color;
    }

    public static ConsoleText of(String text, Color color) {
        return new ConsoleText(text, color);
    }

    public String getText() {
        return text;
    }

    public Color getColor() {
        return color;
    }
}
