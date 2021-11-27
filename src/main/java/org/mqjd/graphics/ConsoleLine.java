package org.mqjd.graphics;

import org.fusesource.jansi.Ansi;
import org.mqjd.common.BoundingRect;
import org.mqjd.common.Point;
import org.mqjd.common.SpecialCharacter;
import org.mqjd.element.Border;
import org.mqjd.element.Drawer;
import org.mqjd.element.Text;
import org.mqjd.utils.StringUtil;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.fusesource.jansi.Ansi.ansi;

public class ConsoleLine implements Drawer {
    private int length;
    private final List<Text> texts = new ArrayList<>();
    private final Graphics graphics;

    public ConsoleLine(Graphics graphics) {
        this.graphics = graphics;
    }

    @Override
    public void draw() {
        texts.sort(Comparator.comparingInt(Text::getPosition));
        List<Text> texts = new ArrayList<>();
        int position = 0;
        for (Text text : this.texts) {
            int space = text.getPosition() - position;
            if (space > 1) {
                texts.add(new Text(graphics, Point.of(position + 1, text.getPoint().getY()), IntStream.range(0, space - 1).mapToObj(v -> " ").collect(Collectors.joining()), text.getColor()));
                texts.add(text);
                position = text.getPosition() + text.getLength() - 1;
            } else if (space < 1) {
                Text text1 = texts.get(texts.size() - 1);
                if (text1.mergeable(text)) {
                    Border merge = text1.merge(text);
                    texts.remove(texts.size() - 1);
                    texts.add(merge);
                    position = merge.getPosition() + merge.getLength() - 1;
                } else {
                    Text newText = text.cut(1 - space);
                    int newTextLength = newText.getLength();
                    if (newTextLength > 0) {
                        texts.add(newText);
                        position = position + newText.getLength();
                    }
                }
            } else {
                texts.add(text);
                position = text.getPosition() + text.getLength() - 1;
            }
        }
        Ansi ansi = ansi().eraseScreen();
        for (Text text : texts) {
            ansi.fg(text.getColor().getColor()).a(text.getText());
        }
        System.out.println(ansi);
    }


    public static void drawEmpty() {
        System.out.println();
    }

    public void add(Text text) {
        BoundingRect boundingRect = text.getBoundingRect();
        texts.add(text);
        length = Math.max(boundingRect.getX() + boundingRect.getWidth(), length);
    }
}
