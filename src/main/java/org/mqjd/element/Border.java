package org.mqjd.element;

import org.mqjd.common.Color;
import org.mqjd.common.Point;
import org.mqjd.graphics.Graphics;
import org.mqjd.utils.StringUtil;

public class Border extends Text {
    public Border(Graphics graphics, Point point, String text, Color color) {
        super(graphics, point, text, color);
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
