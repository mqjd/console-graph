package org.mqjd.graphics;

import org.fusesource.jansi.Ansi;
import org.mqjd.component.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.fusesource.jansi.Ansi.ansi;

public class ConsoleLine implements Component {
    private int length;
    private final List<Text> texts = new ArrayList<>();

    public void add(Text text) {
        texts.add(text);
        length = Math.max(text.getPosition() + text.getLength(), length);
    }

    public int getLength() {
        return length;
    }

    @Override
    public void draw() {
        texts.sort(Comparator.comparingInt(Text::getPosition));
        Ansi ansi = ansi().eraseScreen();
        int position = -1;
        int textLength;
        for (Text text : texts) {
            textLength = text.getLength();
            int space = text.getPosition() - position - 1;
            if (space > 0) {
                ansi.a(IntStream.range(0, space).mapToObj(v -> " ").collect(Collectors.joining()));
                ansi.fg(text.getColor().getColor()).a(text.getText());
            } else if (space < 0) {
                Text newText = text.cut(-1 - space);
                textLength = newText.getLength();
                ansi.fg(newText.getColor().getColor()).a(newText.getText());
            } else {
                ansi.fg(text.getColor().getColor()).a(text.getText());
            }
            position = text.getPosition() + textLength;
        }
        System.out.println(ansi);
    }

    public static void drawEmpty() {
        System.out.println();
    }
}
