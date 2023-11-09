package com.medical.common.util;

public enum WorkShift {
    MAÑANA("mañana"),
    TARDE("tarde"),
    NOCHE("noche"),
    DIA_COMPLETO("todo el dia");


    private String value;

    WorkShift(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
