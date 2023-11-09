package com.medical.common.util;

public enum SpecializationEnum {

    CARDIOLOGIA("CARDIOLOGIA", 1L),
    DERMATOLOGIA("DERMATOLOGIA", 2L),
    ENDOCRINOLOGIA("ENDOCRINOLOGIA", 3L),
    GASTROENTEROLOGIA("GASTROENTEROLOGIA", 4L),
    HEMATOLOGIA("HEMATOLOGIA", 5L),
    INFECTOLOGIA("INFECTOLOGIA", 6L),
    NEFROLOGIA("NEFROLOGIA", 7L),
    NEUMOLOGIA("NEUMOLOGIA", 8L),
    NEUROLOGIA("NEUROLOGIA", 9L),
    ONCOLOGIA("ONCOLOGIA", 10L),
    OFTALMOLOGIA("OFTALMOLOGIA", 11L),
    OTORRINOLARINGOLOGIA("OTORRINOLARINGOLOGIA", 12L),
    PEDIATRIA("PEDIATRIA", 13L),
    PSIQUIATRIA("PSIQUIATRIA", 14L),
    REUMATOLOGIA("REUMATOLOGIA", 15L);


    private String value;
    private Long id;

    SpecializationEnum(String value, Long id) {
        this.value = value;
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
