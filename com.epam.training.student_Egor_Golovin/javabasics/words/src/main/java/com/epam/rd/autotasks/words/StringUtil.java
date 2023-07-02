package com.epam.rd.autotasks.words;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.regex.Pattern;

public class StringUtil {
    public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) {
        if (sample != null && words != null) {
            int count = 0;
            for (String word : words) {
                if (word.trim().equalsIgnoreCase(sample.trim())) {
                    count++;
                }
            } return count;
        } else return 0;
    }

    public static String[] splitWords(String text) {
        if (text == null) return null;
        if (!text.equals("")) {
            text =  text.replaceAll("[,.;:\\s?!]+", " ").trim();
            if (!text.equals("")) {
                return text.split("\\s+");
            } else return null;
        } else return null;
    }

    public static String convertPath(String path, boolean toWin) {
        if (path == null || path.equals("")) return null;
        if (Pattern.matches(".*\\\\.*/.*", path) ||
                Pattern.matches(".*/.*\\\\.*", path) ||
                Pattern.matches(".*~\\\\.*", path) ||
                Pattern.matches(".+C:.*", path) ||
                Pattern.matches(".*//.*", path)) return null;
        if (toWin) {
            if (path.startsWith("/")) {
                path = "C:" + path;
            }
            path = path.replace("~", "C:\\User").replaceAll("/", "\\\\");
            if (!Pattern.matches("[C:]*\\w*([\\\\?\\w _.\\-]+)?\\.*\\\\?([\\w-_.]+\\w?)?\\\\?", path)) return null;
        } else {
            path = path.replace("C:\\User", "~").replace("C:\\", "/").replaceAll("\\\\", "/");
            if (!Pattern.matches("~?\\w*([/?\\w _.\\-]+)?\\.*/?([\\w-_.]*\\w?)?/?", path)) return null;
        }
        return path;
    }

    public static String joinWords(String[] words) {
        if (words == null) return null;
        boolean arrOfEmptyStr = true;
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (String word : words) {
            if (!word.equals("")) {
                joiner.add(word);
                arrOfEmptyStr = false;
            }
        }
        if (arrOfEmptyStr) {
            return null;
        } else return joiner.toString();
    }

    public static void main(String[] args) {
        System.out.println("Test 1: countEqualIgnoreCaseAndSpaces");
        String[] words = new String[]{" WordS    \t", "words", "w0rds", "WOR  DS", };
        String sample = "words   ";
        int countResult = countEqualIgnoreCaseAndSpaces(words, sample);
        System.out.println("Result: " + countResult);
        int expectedCount = 2;
        System.out.println("Must be: " + expectedCount);

        System.out.println("Test 2: splitWords");
        String text = "   ,, first, second!!!! third";
        String[] splitResult = splitWords(text);
        System.out.println("Result : " + Arrays.toString(splitResult));
        String[] expectedSplit = new String[]{"first", "second", "third"};
        System.out.println("Must be: " + Arrays.toString(expectedSplit));

        System.out.println("Test 3: convertPath");
        String unixPath = "/some/unix/path";
        String convertResult = convertPath(unixPath, true);
        System.out.println("Result: " + convertResult);
        String expectedWinPath = "C:\\some\\unix\\path";
        System.out.println("Must be: " + expectedWinPath);

        System.out.println("Test 4: joinWords");
        String[] toJoin = new String[]{"go", "with", "the", "", "FLOW"};
        String joinResult = joinWords(toJoin);
        System.out.println("Result: " + joinResult);
        String expectedJoin = "[go, with, the, FLOW]";
        System.out.println("Must be: " + expectedJoin);
    }
}