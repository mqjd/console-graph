package org.mqjd.common;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CharacterMixin {

    private static final Map<String, String> CHARACTER_POSITION = new HashMap<>(24);
    private static final Map<String, String> POSITION_CHARACTER = new HashMap<>(24);
    static {
        CHARACTER_POSITION.put(SpecialCharacter.MIDDLE_SINGLE_LINE, "00000101");
        CHARACTER_POSITION.put(SpecialCharacter.MIDDLE_SINGLE_LINE_VERTICAL, "00001010");
        CHARACTER_POSITION.put(SpecialCharacter.CHARACTER1, "00000011");
        CHARACTER_POSITION.put(SpecialCharacter.CHARACTER2, "00001001");
        CHARACTER_POSITION.put(SpecialCharacter.CHARACTER3, "00001100");
        CHARACTER_POSITION.put(SpecialCharacter.CHARACTER4, "00000110");
        CHARACTER_POSITION.put(SpecialCharacter.CHARACTER5, "00000111");
        CHARACTER_POSITION.put(SpecialCharacter.CHARACTER6, "00001011");
        CHARACTER_POSITION.put(SpecialCharacter.CHARACTER7, "00001101");
        CHARACTER_POSITION.put(SpecialCharacter.CHARACTER8, "00001110");
        CHARACTER_POSITION.put(SpecialCharacter.CHARACTER9, "00001111");

        CHARACTER_POSITION.put(SpecialCharacter.MIDDLE_DOUBLE_LINE, "01010101");
        CHARACTER_POSITION.put(SpecialCharacter.MIDDLE_DOUBLE_LINE_VERTICAL, "10101010");
        CHARACTER_POSITION.put(SpecialCharacter.CHARACTER11, "00110011");
        CHARACTER_POSITION.put(SpecialCharacter.CHARACTER12, "10011001");
        CHARACTER_POSITION.put(SpecialCharacter.CHARACTER13, "11001100");
        CHARACTER_POSITION.put(SpecialCharacter.CHARACTER14, "01100110");
        CHARACTER_POSITION.put(SpecialCharacter.CHARACTER15, "01110111");
        CHARACTER_POSITION.put(SpecialCharacter.CHARACTER16, "10111011");
        CHARACTER_POSITION.put(SpecialCharacter.CHARACTER17, "11011101");
        CHARACTER_POSITION.put(SpecialCharacter.CHARACTER18, "11101110");
        CHARACTER_POSITION.put(SpecialCharacter.CHARACTER19, "11111111");

        CHARACTER_POSITION.put(SpecialCharacter.CHARACTER55, "10101111");
        CHARACTER_POSITION.put(SpecialCharacter.CHARACTER56, "01011111");

        CHARACTER_POSITION.put(SpecialCharacter.CHARACTER57, "01010111");
        CHARACTER_POSITION.put(SpecialCharacter.CHARACTER58, "01011101");
        CHARACTER_POSITION.put(SpecialCharacter.CHARACTER59, "10101011");
        CHARACTER_POSITION.put(SpecialCharacter.CHARACTER61, "10101110");

        CHARACTER_POSITION.forEach((k, v) -> POSITION_CHARACTER.put(v, k));
    }

    public static Optional<String> mix(String s1, String s2) {
        int result = Integer.valueOf(CHARACTER_POSITION.get(s1), 2) | Integer.valueOf(CHARACTER_POSITION.get(s2), 2);
        return Optional.ofNullable(POSITION_CHARACTER.get(StringUtils.leftPad(Integer.toBinaryString(result), 8, '0')));
    }
}
