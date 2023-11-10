package com.medical.presentation.controller.endpoint;

public interface SpecializationEndpoint {

    String BASE = "/specialization";

    String SPECIALIZATION_BY_ID = "/{specializationId}";
    String SPECIALIZATIONS = "/specializations";
    String DESCRIPTION = "description";
    String SPECIALIZATION_DESCRIPTION = "specializationDescription";

    String SPECIALIZATION_BY_DESCRIPTION = "/{" + DESCRIPTION + "}/{" + SPECIALIZATION_DESCRIPTION + "}";
}
