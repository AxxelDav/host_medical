package com.medical.presentation.controller.endpoint;

public interface MedicalBranchEndpoint {

    String BASE = "/medical-branch";

    String LOCALE = "locale";
    String STREET_NUMBER = "streetNumber";
    String STREET = "street";
    String SPECIALIZATION_BY_ID = "specializationId";
    String PROFESSIONAL_ID = "professionalId";

    String MEDICAL_BRANCH_ID = "/{medicalBranchId}";
    String FIND_LOCAL_AND_NUMBER_AND_STREET= "/{" + LOCALE + "}/{" + STREET_NUMBER + "}/{" + STREET + "}";
    String FIND_MEDICAL_BRANCH_BY_SPECIALIZATION_AND_PROFESSIONAL = "/{" + SPECIALIZATION_BY_ID + "}/{" + PROFESSIONAL_ID + "}";

}




