package com.medical.presentation.controller.endpoint;

public interface ProfessionalEndpoint {

    String BASE = "/v1/professional";

    String PROFESSIONAL_ID = "/{professionalId}";
    String PROFESSIONAL = "professionalId";
    String SPECIALIZATIONID = "specializationId";
    String WORKING_SHIFT_ID = "/{workingShiftId}";
    String SPECIALIZATION_ID = "/specialization/{specializationId}";
    String TIME_CONSULTATION_ID = "timeConsultationId";
    String WORKING_DAY_ID = "/{workingDayId}";
    String WORKING_DAYS = "/workingdays";
    String TIME_CONSULTATION = "/time-consultation";
    String SPECIALIZATION = "specialization";
    String REGISTRATION_PROFESSIONAL_DATE = "registrationProfessionalDate";

    String UPDATE_TIME_CONSULTATION = TIME_CONSULTATION + "/{" + PROFESSIONAL + "}/{" + TIME_CONSULTATION_ID + "}";
    String UPDATE_WORKING_DAYS = PROFESSIONAL_ID + WORKING_DAYS;
    String UPDATE_SPECIALIZATION = "/{" + SPECIALIZATION + "}/{" + PROFESSIONAL + "}/{" + SPECIALIZATIONID + "}";
    String CREATE_SCHEDULES_FOR_PROFESSIONAL = PROFESSIONAL_ID;
}
