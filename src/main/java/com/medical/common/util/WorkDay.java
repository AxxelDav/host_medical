package com.medical.common.util;

public enum WorkDay {
    LUNES("lunes"),
    MARTES("martes"),
    MIERCOLES("miércoles"),
    JUEVES("jueves"),
    VIERNES("viernes"),
    SABADO("sábado"),
    DOMINGO("domingo");

    private String value;

    WorkDay(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
