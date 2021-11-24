package org.mqjd.common;

public enum LineStyle {
    TOP_SINGLE(SpecialCharacter.TOP_SINGLE_LINE),
    MIDDLE_SINGLE(SpecialCharacter.MIDDLE_SINGLE_LINE),
    BOTTOM_SINGLE(SpecialCharacter.BOTTOM_SINGLE_LINE);
    private final String text;

    LineStyle(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
