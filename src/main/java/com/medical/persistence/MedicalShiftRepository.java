package com.medical.persistence;

import com.medical.domain.model.MedicalShift;
import com.medical.domain.model.WorkingDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalShiftRepository extends JpaRepository<MedicalShift, Long> {

    @Query(value = "SELECT tm.TURNO_MEDICO_ID, tm.FECHA, tm.DISPONIBLE, tm.SUCURSAL_ID, tm.PROFESIONAL_ID, tm.USUARIO_ID " +
            "FROM TURNO_MEDICO tm " +
            "INNER JOIN professional p ON tm.PROFESIONAL_ID = p.PROFESIONAL_ID " +
            "INNER JOIN especialidad e ON p.ESPECIALIDAD_ID = e.ESPECIALIDAD_ID " +
            "WHERE tm.DISPONIBLE = 'SI' AND tm.FECHA > :specializationId", nativeQuery = true)
    List<MedicalShift> findAllMedicalShiftAvailableBySpecializationId(Long specializationId);



    @Query(value = "SELECT tm.TURNO_MEDICO_ID, tm.FECHA, tm.DISPONIBLE, tm.MODALIDAD, tm.SUCURSAL_ID, tm.PROFESIONAL_ID, tm.USUARIO_ID " +
            "FROM TURNO_MEDICO tm " +
            "INNER JOIN PROFESIONAL p ON tm.PROFESIONAL_ID = p.PROFESIONAL_ID " +
            "WHERE tm.ESPECIALIDAD_ID = :specializationId " +
            "AND (:professionalId IS NULL OR tm.PROFESIONAL_ID = :professionalId) " +
            "AND (:medicalBranchId IS NULL OR tm.SUCURSAL_ID = :medicalBranchId) " +
            "AND (:workingMonthId IS NULL OR MONTH(FECHA) = :workingMonthId) " +
            "AND CASE " +
            "    WHEN DAYNAME(FECHA) = 'Monday' AND 'Lunes' IN :workingDays THEN 1 " +
            "    WHEN DAYNAME(FECHA) = 'Tuesday' AND 'Martes' IN :workingDays THEN 1 " +
            "    WHEN DAYNAME(FECHA) = 'Wednesday' AND 'Miércoles' IN :workingDays THEN 1 " +
            "    WHEN DAYNAME(FECHA) = 'Thursday' AND 'Jueves' IN :workingDays THEN 1 " +
            "    WHEN DAYNAME(FECHA) = 'Friday' AND 'Viernes' IN :workingDays THEN 1 " +
            "END " +
            "AND p.TURNO_LABORAL_ID = :workingShiftId " +
            "AND tm.DISPONIBLE = 'SI'", nativeQuery = true)
    List<MedicalShift> requestMedicalShift(Long specializationId, Long professionalId, Long medicalBranchId, Long workingMonthId, List<WorkingDay> workingDays, Long workingShiftId);

}
