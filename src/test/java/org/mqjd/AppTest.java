package org.mqjd;

import org.junit.Test;
import org.mqjd.common.*;
import org.mqjd.element.Rect;
import org.mqjd.graphics.Graphics;
import org.mqjd.layout.DirLayout;
import org.mqjd.utils.StringUtil;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
            String value = (String)field.get(SpecialCharacter.class);
            System.out.printf("field is %s , character is %s , size is %s%n", field.getName(), value,
                StringUtil.getStringWidth(value));
        }
    }

    @Test
    public void testPrintDirectory() {
        Graphics graphics = new Graphics();
        graphics.add(new DirLayout(graphics, Point.of(1, 1), new File("/Users/qiang.ma1/scala-2.12.8"))).draw();
    }

    @Test
    public void testPrintRect() {
        Graphics graphics = new Graphics();
        graphics.add(new Rect(graphics, Point.of(10, 6), Size.of(10, 4)))
            .add(new Rect(graphics, Point.of(22, 6), Size.of(10, 4)))
            .add(new Rect(graphics, Point.of(10, 10), Size.of(10, 4)))
            .add(new Rect(graphics, Point.of(22, 10), Size.of(10, 4)))
            .add(new Rect(graphics, Point.of(1, 8), Size.of(10, 4)))
            .add(new Rect(graphics, Point.of(16, 8), Size.of(10, 4)))
            .add(new Rect(graphics, Point.of(16, 3), Size.of(10, 4)))
            .add(new Rect(graphics, Point.of(16, 13), Size.of(10, 4)))
            .add(new Rect(graphics, Point.of(31, 8), Size.of(10, 4))).draw();
    }

    @Test
    public void testMix() {
        Optional<String> mix = CharacterMixin.mix(SpecialCharacter.MIDDLE_DOUBLE_LINE, SpecialCharacter.CHARACTER11);
        assertTrue(mix.isPresent());
        assertEquals(SpecialCharacter.CHARACTER15, mix.get());
    }
}
