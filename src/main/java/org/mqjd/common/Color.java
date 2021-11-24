package org.mqjd.common;

import org.fusesource.jansi.Ansi;

public enum Color {
    BLACK(Ansi.Color.BLACK),
    RED(Ansi.Color.RED),
    GREEN(Ansi.Color.GREEN),
    YELLOW(Ansi.Color.YELLOW),
    BLUE(Ansi.Color.BLUE),
    MAGENTA(Ansi.Color.MAGENTA),
    CYAN(Ansi.Color.CYAN),
    WHITE(Ansi.Color.WHITE),
    DEFAULT(Ansi.Color.DEFAULT);

    private final Ansi.Color color;
    Color(Ansi.Color color) {
        this.color = color;
    }

    public Ansi.Color getColor() {
        return color;
    }
}
