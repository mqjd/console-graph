package org.mqjd.layout;

import org.mqjd.common.BoundingRect;
import org.mqjd.common.Color;
import org.mqjd.common.Point;
import org.mqjd.common.SpecialCharacter;
import org.mqjd.element.Text;
import org.mqjd.graphics.Graphics;

import java.io.File;
import java.util.Objects;

public class DirLayout implements Layout {
    private static final String EMPTY_PREFIX = "";
    private static final String FILE_PREFIX = SpecialCharacter.PLUS + SpecialCharacter.MINUS;
    private static final String DIRECTORY_PREFIX = SpecialCharacter.CHARACTER21 + SpecialCharacter.MINUS;
    private final Graphics graphics;
    private final File directory;
    private final Point point;

    public DirLayout(Graphics graphics, Point point, File directory) {
        this.graphics = graphics;
        this.point = point;
        if (!directory.exists() || !directory.isDirectory()) {
            throw new IllegalArgumentException("directory must be exists:" + directory);
        }
        this.directory = directory;
    }

    @Override
    public void draw() {
        currentLine = 0;
        drawFile(directory, 0);
    }

    private int currentLine = 0;

    private void drawFile(File file, int deep) {
        String prefix;
        if (deep == 0) {
            prefix = EMPTY_PREFIX;
        } else if (file.isDirectory()) {
            prefix = DIRECTORY_PREFIX;
        } else {
            prefix = FILE_PREFIX;
        }
        graphics.draw(new Text(graphics, Point.of(point.getX() + deep * 2, currentLine + point.getY()), prefix + file.getName(), Color.WHITE));
        currentLine++;
        if (file.isFile()) {
            return;
        }
        File[] listFiles = Objects.requireNonNull(file.listFiles(), "file is not valid:" + file);
        for (File dirFile : listFiles) {
            drawFile(dirFile, deep + 1);
        }
    }

    @Override
    public BoundingRect getBoundingRect() {
        return null;
    }
}
