package com.medical.presentation.controller.endpoint;

public interface MedicalShiftEndpoint {

    String BASE = "/v1/medical-shift";

    String MEDICAL_SHIFT_ID = "/{medicalShiftId}";
    String ESPECIALIZATION_ID = "/{specializationId}";
    String PROFESSIONAL_ID = "/{professionalId}";
    String MEDICAL_BRANCH_ID = "/{medicalBranchId}";
    String WORKING_MONTH_ID = "/{workingMonthId}";
    String WORKING_SHIFT_ID = "/{workingShiftId}";
    String ALL_MEDICAL_SHIFT_BY_SPECIALIZATION = "/specialization/";
    String USER_ID = "/{userId}";
    String REGISTRATION_PROFESSIONAL_DATE = "/{registrationProfessionalDate}";
    String PROFESSIONALS = "/professionals";
    String SPECIALIZATIONS = "/specializations";
    String REQUEST_MEDICAL_SHIFT = ESPECIALIZATION_ID + PROFESSIONAL_ID + MEDICAL_BRANCH_ID + WORKING_MONTH_ID + WORKING_SHIFT_ID;
    String TAKE_MEDICAL_SHIFT = MEDICAL_SHIFT_ID + USER_ID;

}
