package org.mqjd.graphics;

import org.fusesource.jansi.Ansi;
import org.mqjd.common.BoundingRect;
import org.mqjd.element.Drawer;
import org.mqjd.element.Text;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.fusesource.jansi.Ansi.ansi;

public class ConsoleLine implements Drawer {
    private int length;
    private final List<Text> texts = new ArrayList<>();

    @Override
    public void draw() {
        texts.sort(Comparator.comparingInt(Text::getPosition));
        List<ConsoleText> consoleTexts = new ArrayList<>();
        int position = 0;
        for (Text text : texts) {
            int space = text.getPosition() - position;
            if (space > 1) {
                consoleTexts.add(ConsoleText.of(IntStream.range(0, space - 1).mapToObj(v -> " ").collect(Collectors.joining()), text.getColor()));
                consoleTexts.add(ConsoleText.of(text.getText(), text.getColor()));
                position = text.getPosition() + text.getLength() - 1;
            } else if (space < 1) {
                Text newText = text.cut(1 - space);
                int newTextLength = newText.getLength();
                if (newTextLength > 0) {
                    consoleTexts.add(ConsoleText.of(newText.getText(), newText.getColor()));
                    position = position + newText.getLength();
                }
            } else {
                consoleTexts.add(ConsoleText.of(text.getText(), text.getColor()));
                position = text.getPosition() + text.getLength() - 1;
            }
        }
        Ansi ansi = ansi().eraseScreen();
        for (ConsoleText consoleText : consoleTexts) {
            ansi.fg(consoleText.getColor().getColor()).a(consoleText.getText());
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
