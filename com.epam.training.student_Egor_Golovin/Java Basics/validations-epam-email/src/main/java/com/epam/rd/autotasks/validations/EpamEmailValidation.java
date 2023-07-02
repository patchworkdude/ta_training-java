package com.epam.rd.autotasks.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EpamEmailValidation {

    public static boolean validateEpamEmail(String email) {
        if (email != null) {
            Pattern p = Pattern.compile("\\w+_\\w+\\d*@epam\\.com");
            Matcher m = p.matcher(email);
            return m.matches();
        } else return false;
    }
}





