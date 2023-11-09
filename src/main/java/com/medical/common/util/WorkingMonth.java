package com.medical.common.util;

public enum WorkingMonth {

    LUNES("lunes"),
    MARTES("martes"),
    MIERCOLES("miércoles"),
    JUEVES("jueves"),
    VIERNES("viernes"),
    SABADO("sábado"),
    DOMINGO("domingo");

    private String value;

    WorkingMonth(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
