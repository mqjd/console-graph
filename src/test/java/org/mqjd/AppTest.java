package org.mqjd;

import org.junit.Test;
import org.mqjd.common.Color;
import org.mqjd.common.Point;
import org.mqjd.common.Size;
import org.mqjd.common.SpecialCharacter;
import org.mqjd.element.Rect;
import org.mqjd.graphics.Graphics;
import org.mqjd.layout.DirLayout;
import org.mqjd.utils.StringUtil;

import java.io.File;
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
    public void testSpecialCharacterLength() {
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

    @Test
    public void testPrintDirectory() {
        Graphics graphics = new Graphics();
        graphics.add(new DirLayout(graphics, Point.of(1, 1), new File("/Users/qiang.ma1/scala-2.12.8")))
                .draw();
    }


    @Test
    public void testPrintRect() {
        Graphics graphics = new Graphics();
        graphics.add(new Rect(graphics, Point.of(10, 2), Size.of(10, 4)))
                .add(new Rect(graphics, Point.of(22, 2), Size.of(10, 4)))
                .add(new Rect(graphics, Point.of(16, 4), Size.of(10, 4)))
                .add(new Rect(graphics, Point.of(10, 6), Size.of(10, 4)))
                .add(new Rect(graphics, Point.of(22, 6), Size.of(10, 4)))
                .add(new Rect(graphics, Point.of(15, 3), Size.of(10, 4)))
                .draw();
    }
}
