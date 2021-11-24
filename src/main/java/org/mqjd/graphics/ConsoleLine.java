package org.mqjd.graphics;

import org.mqjd.component.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
        texts.forEach(text -> {
            System.out.println(ansi().eraseScreen().fg(text.getColor().getColor()).a(text.getText()));
        });
    }

    public static void drawEmpty() {
        System.out.println();
    }
}
