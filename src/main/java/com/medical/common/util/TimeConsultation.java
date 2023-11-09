package com.medical.common.util;

public enum TimeConsultation {

    FOR_15_MINUTES(1L),
    FOR_20_MINUTES(2L),
    FOR_30_MINUTES(3L),
    FOR_45_MINUTES(4L),
    FOR_60_MINUTES(5L);


    private final Long id;

    TimeConsultation(Long id) {
        this.id = id;
    }

    public Long id() {
        return this.id;
    }
}
