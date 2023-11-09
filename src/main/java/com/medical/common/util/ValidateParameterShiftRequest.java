package com.medical.common.util;

import com.medical.business.service.MedicalBranchService;
import com.medical.business.service.SpecializationService;
import com.medical.business.service.WorkingDayService;
import org.springframework.stereotype.Component;

@Component
public class ValidateParameterShiftRequest {

    private SpecializationService specializationService;
    private WorkingDayService workingDayService;
    private MedicalBranchService medicalBranchService;

    public ValidateParameterShiftRequest(SpecializationService specializationService, WorkingDayService workingDayService, MedicalBranchService medicalBranchService) {
        this.specializationService = specializationService;
        this.workingDayService = workingDayService;
        this.medicalBranchService = medicalBranchService;
    }

    public void validate(String specialization, String month, String locale, String streetNumber, String street, String workingDay, String dayshift) throws Exception {

        if (specializationService.findSpecializationByDescripcion(specialization) == null) {
            throw new Exception("Especialidad no válida. Debe ser una de las especialidades médicas disponibles.");
        }

        if (!isValidateMonth(month)) {
            throw new Exception("Mes ingresado no válido.");
        }

        if (medicalBranchService.findByLocaleAndNumberAndStreet(locale, streetNumber, street) == null) {
            throw new Exception("Sucursal ingresada no válida.");
        }

        if (!isValidateWorkingDay(workingDay)) {
            throw new Exception("Día ingresado no válido.");
        }

        if (!isValidateDayshift(dayshift)) {
            throw new Exception("Turno ingresado no válido.");
        }

    }




    public Boolean isValidateMonth(String month) {
        try {
            Months monthValue = Months.valueOf(month);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public Boolean isValidateWorkingDay(String workingDay) {
        try {
            WorkingDay.valueOf(workingDay);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public Boolean isValidateDayshift(String dayshift) {
        try {
            WorkShift.valueOf(dayshift);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
