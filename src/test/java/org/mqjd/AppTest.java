package org.mqjd;

import org.junit.Test;
import org.mqjd.common.SpecialCharacter;
import org.mqjd.utils.StringUtil;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * printSpecialCharacter
     */
    @Test
    public void printSpecialCharacter() throws IllegalAccessException {
        Field[] fields = SpecialCharacter.class.getDeclaredFields();
        for (Field field : fields) {
            String value = (String) field.get(SpecialCharacter.class);
            System.out.printf("field is %s , character is %s , size is %s%n", field.getName(), value, StringUtil.getStringWidth(value));
        }
    }

    @Test
    public void testSpecialCharacterLength() throws IllegalAccessException {
        Field[] fields = SpecialCharacter.class.getDeclaredFields();
        String collect = Arrays.stream(fields).map(field -> {
            try {
                return (String) field.get(SpecialCharacter.class);
            } catch (IllegalAccessException e) {
                return "";
            }
        }).collect(Collectors.joining());
        System.out.println(collect);
        System.out.println(IntStream.range(0, collect.length() / 2 + 1).mapToObj(v -> "哈").collect(Collectors.joining()));
        System.out.println(collect.length());
        System.out.println(collect.getBytes().length);
    }
}
