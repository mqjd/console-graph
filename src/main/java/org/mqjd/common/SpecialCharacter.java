package org.mqjd.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SpecialCharacter {
    public static final String TOP_SINGLE_LINE_HORIZONTAL = "¯";
    public static final String MIDDLE_SINGLE_LINE = "─";
    public static final String MIDDLE_SINGLE_LINE_VERTICAL = "│";
    public static final String MIDDLE_DOUBLE_LINE = "═";
    public static final String MIDDLE_DOUBLE_LINE_VERTICAL = "║";
    public static final String BOTTOM_SINGLE_LINE = "_";
    public static final String PLUS = "+";
    public static final String MINUS = "-";

    public static final String CHARACTER1 = "┌";
    public static final String CHARACTER2 = "└";
    public static final String CHARACTER3 = "┘";
    public static final String CHARACTER4 = "┐";
    public static final String CHARACTER5 = "┬";
    public static final String CHARACTER6 = "├";
    public static final String CHARACTER7 = "┴";
    public static final String CHARACTER8 = "┤";
    public static final String CHARACTER9 = "┼";

    public static final String CHARACTER11 = "╔";
    public static final String CHARACTER12 = "╚";
    public static final String CHARACTER13 = "╝";
    public static final String CHARACTER14 = "╗";
    public static final String CHARACTER15 = "╦";
    public static final String CHARACTER16 = "╠";
    public static final String CHARACTER17 = "╩";
    public static final String CHARACTER18 = "╣";
    public static final String CHARACTER19 = "╬";


    public static final String CHARACTER21 = "\\";
    public static final String CHARACTER22 = "/";
    public static final String CHARACTER23 = "⁀";
    public static final String CHARACTER24 = "‿";
    public static final String CHARACTER25 = "⁔";
    public static final String CHARACTER26 = "(";
    public static final String CHARACTER27 = ")";
    public static final String CHARACTER28 = "◯";
    public static final String CHARACTER29 = "●";

    public static final String CHARACTER41 = "▲";
    public static final String CHARACTER42 = "◀";
    public static final String CHARACTER43 = "▼";
    public static final String CHARACTER44 = "▶";
    public static final String CHARACTER45 = "◤";
    public static final String CHARACTER46 = "◣";
    public static final String CHARACTER47 = "◢";
    public static final String CHARACTER48 = "◥";

    public static final String CHARACTER51 = "◸";
    public static final String CHARACTER52 = "◺";
    public static final String CHARACTER53 = "◿";
    public static final String CHARACTER54 = "◹";

    public static Map<MixinKey, String> mixins = new HashMap<>();

    static {
        mixins.put(MixinKey.of(CHARACTER1, CHARACTER2), CHARACTER6);
        mixins.put(MixinKey.of(CHARACTER1, CHARACTER3), CHARACTER9);
        mixins.put(MixinKey.of(CHARACTER2, CHARACTER3), CHARACTER7);
        mixins.put(MixinKey.of(CHARACTER1, CHARACTER4), CHARACTER5);
        mixins.put(MixinKey.of(CHARACTER2, CHARACTER4), CHARACTER9);
        mixins.put(MixinKey.of(CHARACTER3, CHARACTER4), CHARACTER8);
        mixins.put(MixinKey.of(MIDDLE_SINGLE_LINE, CHARACTER1), CHARACTER5);
        mixins.put(MixinKey.of(MIDDLE_SINGLE_LINE, CHARACTER2), CHARACTER7);
        mixins.put(MixinKey.of(MIDDLE_SINGLE_LINE, CHARACTER3), CHARACTER7);
        mixins.put(MixinKey.of(MIDDLE_SINGLE_LINE, CHARACTER4), CHARACTER5);
        mixins.put(MixinKey.of(MIDDLE_SINGLE_LINE, CHARACTER5), CHARACTER5);
        mixins.put(MixinKey.of(MIDDLE_SINGLE_LINE, CHARACTER6), CHARACTER9);
        mixins.put(MixinKey.of(MIDDLE_SINGLE_LINE, CHARACTER7), CHARACTER7);
        mixins.put(MixinKey.of(MIDDLE_SINGLE_LINE, CHARACTER8), CHARACTER9);
        mixins.put(MixinKey.of(MIDDLE_SINGLE_LINE, CHARACTER9), CHARACTER9);
        mixins.put(MixinKey.of(MIDDLE_SINGLE_LINE_VERTICAL, CHARACTER1), CHARACTER6);
        mixins.put(MixinKey.of(MIDDLE_SINGLE_LINE_VERTICAL, CHARACTER2), CHARACTER6);
        mixins.put(MixinKey.of(MIDDLE_SINGLE_LINE_VERTICAL, CHARACTER3), CHARACTER8);
        mixins.put(MixinKey.of(MIDDLE_SINGLE_LINE_VERTICAL, CHARACTER4), CHARACTER8);
        mixins.put(MixinKey.of(MIDDLE_SINGLE_LINE_VERTICAL, CHARACTER5), CHARACTER9);
        mixins.put(MixinKey.of(MIDDLE_SINGLE_LINE_VERTICAL, CHARACTER6), CHARACTER6);
        mixins.put(MixinKey.of(MIDDLE_SINGLE_LINE_VERTICAL, CHARACTER7), CHARACTER9);
        mixins.put(MixinKey.of(MIDDLE_SINGLE_LINE_VERTICAL, CHARACTER8), CHARACTER8);
        mixins.put(MixinKey.of(MIDDLE_SINGLE_LINE_VERTICAL, CHARACTER9), CHARACTER9);
        mixins.put(MixinKey.of(MIDDLE_SINGLE_LINE, MIDDLE_SINGLE_LINE_VERTICAL), CHARACTER9);

        mixins.put(MixinKey.of(CHARACTER11, CHARACTER12), CHARACTER16);
        mixins.put(MixinKey.of(CHARACTER11, CHARACTER13), CHARACTER19);
        mixins.put(MixinKey.of(CHARACTER12, CHARACTER13), CHARACTER17);
        mixins.put(MixinKey.of(CHARACTER11, CHARACTER14), CHARACTER15);
        mixins.put(MixinKey.of(CHARACTER12, CHARACTER14), CHARACTER19);
        mixins.put(MixinKey.of(CHARACTER13, CHARACTER14), CHARACTER18);
        mixins.put(MixinKey.of(MIDDLE_DOUBLE_LINE, CHARACTER11), CHARACTER15);
        mixins.put(MixinKey.of(MIDDLE_DOUBLE_LINE, CHARACTER12), CHARACTER17);
        mixins.put(MixinKey.of(MIDDLE_DOUBLE_LINE, CHARACTER13), CHARACTER17);
        mixins.put(MixinKey.of(MIDDLE_DOUBLE_LINE, CHARACTER14), CHARACTER15);
        mixins.put(MixinKey.of(MIDDLE_DOUBLE_LINE, CHARACTER15), CHARACTER15);
        mixins.put(MixinKey.of(MIDDLE_DOUBLE_LINE, CHARACTER16), CHARACTER19);
        mixins.put(MixinKey.of(MIDDLE_DOUBLE_LINE, CHARACTER17), CHARACTER17);
        mixins.put(MixinKey.of(MIDDLE_DOUBLE_LINE, CHARACTER18), CHARACTER19);
        mixins.put(MixinKey.of(MIDDLE_DOUBLE_LINE, CHARACTER19), CHARACTER19);
        mixins.put(MixinKey.of(MIDDLE_DOUBLE_LINE_VERTICAL, CHARACTER11), CHARACTER16);
        mixins.put(MixinKey.of(MIDDLE_DOUBLE_LINE_VERTICAL, CHARACTER12), CHARACTER16);
        mixins.put(MixinKey.of(MIDDLE_DOUBLE_LINE_VERTICAL, CHARACTER13), CHARACTER18);
        mixins.put(MixinKey.of(MIDDLE_DOUBLE_LINE_VERTICAL, CHARACTER14), CHARACTER18);
        mixins.put(MixinKey.of(MIDDLE_DOUBLE_LINE_VERTICAL, CHARACTER15), CHARACTER19);
        mixins.put(MixinKey.of(MIDDLE_DOUBLE_LINE_VERTICAL, CHARACTER16), CHARACTER16);
        mixins.put(MixinKey.of(MIDDLE_DOUBLE_LINE_VERTICAL, CHARACTER17), CHARACTER19);
        mixins.put(MixinKey.of(MIDDLE_DOUBLE_LINE_VERTICAL, CHARACTER18), CHARACTER18);
        mixins.put(MixinKey.of(MIDDLE_DOUBLE_LINE_VERTICAL, CHARACTER19), CHARACTER19);
        mixins.put(MixinKey.of(MIDDLE_DOUBLE_LINE, MIDDLE_DOUBLE_LINE_VERTICAL), CHARACTER19);
    }

    public static Optional<String> merge(String s1, String s2) {
        if (s1.equals(s2)) {
            return Optional.of(s1);
        }
        if (CHARACTER9.equals(s1) || CHARACTER9.equals(s2)) {
            return Optional.of(CHARACTER9);
        }
        if (CHARACTER19.equals(s1) || CHARACTER19.equals(s2)) {
            return Optional.of(CHARACTER19);
        }
        return Optional.ofNullable(mixins.get(MixinKey.of(s1, s2)));
    }
}
