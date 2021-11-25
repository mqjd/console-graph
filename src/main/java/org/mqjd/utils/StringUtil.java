package org.mqjd.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    private static final Pattern HALF_WIDTH_PATTERN = Pattern.compile("[\\u4e00-\\u9fa5]");

    public static int getStringWidth(CharSequence s) {
        Matcher matcher = HALF_WIDTH_PATTERN.matcher(s);
        int count = 0;
        if (matcher.find()) {
            count++;
        }
        return s.length() + count;
    }
}
