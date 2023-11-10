package com.medical.presentation.controller.endpoint;

public interface MedicalShiftEndpoint {

    String BASE = "/medical-shift";

    String ID = "/{id}";
    String MEDICAL_SHIFT_ID = "/{medicalShiftId}";
    String REGISTRATION_PROFESSIONAL_DATE = "/{registrationProfessionalDate}";
    String PROFESSIONALS = "/professionals";
    String SPECIALIZATIONS = "/specializations";
    String REQUEST_MEDICAL_SHIFT = "/requestMedicalShift";

}
