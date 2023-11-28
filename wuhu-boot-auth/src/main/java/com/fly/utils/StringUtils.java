package com.fly.utils;

public class StringUtils {
    public static String substringBefore(String str, String separator) {
        if (str == null || separator == null || str.isEmpty() || separator.isEmpty()) {
            return str;
        }
        int separatorIndex = str.indexOf(separator);
        if (separatorIndex != -1) {
            return str.substring(0, separatorIndex);
        } else {
            return str;
        }
    }
}
