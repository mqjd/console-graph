package org.mqjd.graphics;

import static org.fusesource.jansi.Ansi.ansi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.fusesource.jansi.Ansi;
import org.mqjd.component.Component;

public class ConsoleLine implements Component {
    private int length;
    private final List<Text> texts = new ArrayList<>();

    public int getLength() {
        return length;
    }

    @Override
    public void draw() {
        texts.sort(Comparator.comparingInt(Text::getPosition));
        Ansi ansi = ansi().eraseScreen();
        int position = 0;
        for (Text text : texts) {
            int space = text.getPosition() - position;
            if (space > 1) {
                ansi.fg(text.getColor().getColor())
                    .a(IntStream.range(0, space - 1).mapToObj(v -> " ").collect(Collectors.joining()));
                ansi.fg(text.getColor().getColor()).a(text.getText());
                position = text.getPosition() + text.getLength() - 1;
            } else if (space < 1) {
                Text newText = text.cut(1 - space);
                ansi.fg(newText.getColor().getColor()).a(newText.getText());
                int newTextLength = newText.getLength();
                if (newTextLength > 0) {
                    position = position + newText.getLength();
                }
            } else {
                ansi.fg(text.getColor().getColor()).a(text.getText());
                position = text.getPosition() + text.getLength() - 1;
            }
        }
        System.out.println(ansi);
    }

    public static void drawEmpty() {
        System.out.println();
    }

    public void add(Text text) {
        texts.add(text);
        length = Math.max(text.getPoint().getX() + text.getLength(), length);
    }
}
