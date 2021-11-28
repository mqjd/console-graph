package org.mqjd.element;

import org.mqjd.common.CharacterMixin;
import org.mqjd.common.Color;
import org.mqjd.common.Point;
import org.mqjd.common.SpecialCharacter;
import org.mqjd.graphics.Graphics;
import org.mqjd.utils.StringUtil;

import java.util.Optional;

public class Border extends Text {
    public Border(Graphics graphics, Point point, String text, Color color) {
        super(graphics, point, text, color);
    }

    @Override
    public boolean mixable(Element element) {
        return element instanceof Border;
    }

    @Override
    public Border mix(Element element) {
        if (!(element instanceof Border)) {
            throw new IllegalArgumentException("element type must be Border");
        }
        Border border = (Border)element;
        int start = Math.min(getPosition(), border.getPosition());
        int end = Math.max(getPosition() + getText().length(), border.getPosition() + border.getText().length());
        StringBuilder result = new StringBuilder();
        for (int i = start; i < end; i++) {
            result.append(merge(charAt(i), border.charAt(i)));
        }
        return new Border(getGraphics(), Point.of(start, getPoint().getY()), result.toString(), getColor());
    }

    public String merge(String a, String b) {
        if (a == null && b == null) {
            throw new IllegalArgumentException("argument is not valid");
        }
        if (a != null && b != null) {
            return CharacterMixin.mix(a, b).orElseThrow(() -> new IllegalArgumentException("argument is not valid"));
        }

        if (a != null)
            return a;
        return b;
    }

    public String charAt(int index) {
        if (index < getPosition() || getPosition() + getText().length() - 1 < index) {
            return null;
        } else {
            return String.valueOf(getText().charAt(index - getPosition()));
        }

    }

    @Override
    public Border cut(int length) {
        int cutLength = 0;
        for (int i = 0; i < getText().length(); i++) {
            cutLength += StringUtil.getStringWidth(String.valueOf(getText().charAt(i)));
            int space = cutLength - length;
            if (space >= 0) {
                String newText = getText().substring(i + 1);
                return new Border(getGraphics(), getPoint(), space == 1 ? " " + newText : newText, getColor());
            }
        }
        return new Border(getGraphics(), getPoint(), "", getColor());
    }
}
