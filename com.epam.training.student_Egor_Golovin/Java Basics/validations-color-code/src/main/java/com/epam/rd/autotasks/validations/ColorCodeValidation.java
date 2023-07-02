package com.epam.rd.autotasks.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorCodeValidation {
    public static boolean validateColorCode(String color) {
        if (color != null) {
            Pattern p = Pattern.compile("#[0-9A-Fa-f]{6}|#[0-9A-Fa-f]{3}");
            Matcher m = p.matcher(color);
            return m.matches();
        } else return false;

    }
}





