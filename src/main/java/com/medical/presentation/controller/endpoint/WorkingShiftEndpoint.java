package com.medical.presentation.controller.endpoint;

public interface WorkingShiftEndpoint {

    String BASE = "/workshift";

    String LOCALE = "locale";
    String STREET_NUMBER = "streetNumber";
    String STREET = "street";

    String WORKING_SHIFT_ID = "/{workingShiftId}";
    String LOCALE_NUMBER_AND_STREET = "/{" + LOCALE + "}/{" + STREET_NUMBER + "}/{" + STREET + "}";
}
