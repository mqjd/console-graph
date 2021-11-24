package org.mqjd.common;

public enum BorderStyle {
    SINGLE_LINE(SpecialCharacter.CHARACTER1, SpecialCharacter.CHARACTER2, SpecialCharacter.CHARACTER3,
        SpecialCharacter.CHARACTER4, SpecialCharacter.MIDDLE_SINGLE_LINE, SpecialCharacter.MIDDLE_SINGLE_LINE_VERTICAL),
    DOUBLE_LINE(SpecialCharacter.CHARACTER11, SpecialCharacter.CHARACTER12, SpecialCharacter.CHARACTER13,
        SpecialCharacter.CHARACTER14, SpecialCharacter.MIDDLE_DOUBLE_LINE,
        SpecialCharacter.MIDDLE_DOUBLE_LINE_VERTICAL);

    private final String northwest;
    private final String southwest;
    private final String southeast;
    private final String northeast;
    private final String horizontal;
    private final String vertical;

    BorderStyle(String northwest, String southwest, String southeast, String northeast, String horizontal,
        String vertical) {
        this.northwest = northwest;
        this.southwest = southwest;
        this.southeast = southeast;
        this.northeast = northeast;
        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    public String getNorthwest() {
        return northwest;
    }

    public String getSouthwest() {
        return southwest;
    }

    public String getSoutheast() {
        return southeast;
    }

    public String getNortheast() {
        return northeast;
    }

    public String getHorizontal() {
        return horizontal;
    }

    public String getVertical() {
        return vertical;
    }
}
