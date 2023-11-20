package com.medical.common.util;

public class ValidateTypeOfIdParameter {

    public static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }
}
