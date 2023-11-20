package com.medical.persistence;

import com.medical.domain.model.MedicalShift;
import com.medical.domain.model.WorkingDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Repository
public interface MedicalShiftRepository extends JpaRepository<MedicalShift, Long> {

    @Query(value = "SELECT tm.TURNO_MEDICO_ID, tm.FECHA, tm.DISPONIBLE, tm.MODALIDAD, tm.SUCURSAL_ID, tm.PROFESIONAL_ID, tm.USUARIO_ID " +
            "FROM TURNO_MEDICO tm " +
            "INNER JOIN professional p ON tm.PROFESIONAL_ID = p.PROFESIONAL_ID " +
            "INNER JOIN especialidad e ON p.ESPECIALIDAD_ID = e.ESPECIALIDAD_ID " +
            "WHERE tm.DISPONIBLE = 'SI' " +
            "AND e.DESCRIPCION = :specialization " +
            "AND tm.FECHA > NOW()", nativeQuery = true)
    List<MedicalShift> findAllMedicalShiftAvailableBySpecializationId(@Param("specialization") String specialization);



    @Query(value = "SELECT tm.TURNO_MEDICO_ID, tm.FECHA, tm.DISPONIBLE, tm.MODALIDAD, tm.SUCURSAL_ID, tm.PROFESIONAL_ID, tm.USUARIO_ID " +
            "FROM TURNO_MEDICO tm " +
            "INNER JOIN PROFESSIONAL p ON tm.PROFESIONAL_ID = p.PROFESIONAL_ID " +
            "WHERE p.ESPECIALIDAD_ID = :specializationId " +
            "AND (:professionalId IS NULL OR tm.PROFESIONAL_ID = :professionalId) " +
            "AND (:medicalBranchId IS NULL OR tm.SUCURSAL_ID = :medicalBranchId) " +
            "AND (:workingMonthId IS NULL OR MONTH(tm.FECHA) = :workingMonthId) " +
            "AND p.TURNO_LABORAL_ID = :workingShiftId " +
            "AND " +
            "(" +
                "(DAYNAME(tm.FECHA) = 'Monday' AND 'Lunes' IN :days) OR " +
                "(DAYNAME(tm.FECHA) = 'Tuesday' AND 'Martes' IN :days) OR " +
                "(DAYNAME(tm.FECHA) = 'Wednesday' AND 'Miércoles' IN :days) OR " +
                "(DAYNAME(tm.FECHA) = 'Thursday' AND 'Jueves' IN :days) OR " +
                "(DAYNAME(tm.FECHA) = 'Friday' AND 'Viernes' IN :days) " +
            ") " +
            "AND tm.DISPONIBLE = 'SI' " +
            "AND tm.FECHA > NOW()", nativeQuery = true)
    List<MedicalShift> requestMedicalShift(@Param("specializationId") Long specializationId, @Param("professionalId") Long professionalId, @Param("medicalBranchId") Long medicalBranchId, @Param("workingMonthId") Long workingMonthId, @Param("workingShiftId") Long workingShiftId, @Param("days") Set<String> days);

}
