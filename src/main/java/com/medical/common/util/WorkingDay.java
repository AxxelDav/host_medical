package com.medical.common.util;

public enum WorkingDay {
    LUNES("lunes"),
    MARTES("martes"),
    MIERCOLES("miércoles"),
    JUEVES("jueves"),
    VIERNES("viernes"),
    SABADO("sábado"),
    DOMINGO("domingo");

    private String value;

    WorkingDay(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
