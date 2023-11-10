package com.medical.presentation.controller.endpoint;

public interface ProfessionalEndpoint {

    String BASE = "/professional";

    String PROFESSIONAL_ID = "/{professionalId}";
    String PROFESSIONAL = "professionalId";
    String WORKING_SHIFT_ID = "/{workingShiftId}";
    String SPECIALIZATION_ID = "/{specializationId}";
    String TIME_CONSULTATION_ID = "timeConsultationId";
    String WORKING_DAY_ID = "/{workingDayId}";
    String TIME_CONSULTATION = "time-consultation";
    String SPECIALIZATION = "specialization";
    String REGISTRATION_PROFESSIONAL_DATE = "registrationProfessionalDate";

    String UPDATE_TIME_CONSULTATION = "/{" + TIME_CONSULTATION + "}/{" + PROFESSIONAL + "}/{" + TIME_CONSULTATION_ID + "}";
    String UPDATE_SPECIALIZATION = "/{" + SPECIALIZATION + "}/{" + PROFESSIONAL + "}/{" + TIME_CONSULTATION_ID + "}";
    String CREATE_SCHEDULES_FOR_PROFESSIONAL = "/{" + PROFESSIONAL + "}";
}
