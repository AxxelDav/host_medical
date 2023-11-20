package com.medical.presentation.controller.endpoint;

public interface SpecializationEndpoint {

    String BASE = "/v1/specialization";

    String SPECIALIZATION_BY_ID = "/{specializationId}";
    String SPECIALIZATIONS = "/specializations";
    String DESCRIPTION = "description";
    String SPECIALIZATION = "specialization";
    String MODALITY = "modality";
    String MODALITY_ID = "modalityId";

    String SPECIALIZATION_BY_DESCRIPTION = "/" + DESCRIPTION + "/{" + SPECIALIZATION + "}";
    String SPECIALIZATIONS_BY_MODALITY =  MODALITY + "/{" + MODALITY_ID + "}";
}
