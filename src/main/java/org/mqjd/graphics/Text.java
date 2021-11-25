package org.mqjd.graphics;

import org.mqjd.common.Color;
import org.mqjd.utils.StringUtil;

import java.util.Objects;

public class Text {

    private final String text;
    private final Color color;
    private final int position;

    private Text(String text, Color color, int position) {
        this.text = Objects.requireNonNull(text, "text cannot be null");
        this.color = Objects.requireNonNull(color, "color cannot be null");
        this.position = position;
    }

    public static Text of(int position, String text, Color color) {
        return new Text(text, color, position);
    }

    public String getText() {
        return text;
    }

    public Color getColor() {
        return color;
    }

    public Text cut(int length) {
        int cutLength = 0;
        for (int i = text.length(); i > 0; i--) {
            cutLength += StringUtil.getStringWidth(String.valueOf(text.charAt(i - 1)));
            int space = cutLength - length;
            if (space >= 0) {
                String newText = text.substring(0, i - 1);
                return Text.of(position, space == 1 ? newText + " " : newText, color);
            }
        }
        return Text.of(position, text, color);
    }

    public int getLength() {
        return StringUtil.getStringWidth(text);
    }

    public int getPosition() {
        return position;
    }
}
