package com.medical.persistence;

import com.medical.domain.model.Professional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessionalRepository extends JpaRepository<Professional, Long> {

    @Query(value = "SELECT * " +
            "FROM PROFESSIONAL " +
            "WHERE ESPECIALIDAD_ID = :specializationId", nativeQuery = true)
    List<Professional> getProfesionalBySpecializationId(@Param("specializationId") Long specializationId);


    @Query(value = "SELECT * " +
            "FROM PROFESSIONAL " +
            "WHERE TURNO_LABORAL_ID = :workShiftId", nativeQuery = true)
    List<Professional> getAllProfessionalByWorkShiftId(@Param("workShiftId") Long workShiftId);


    @Query(value = "SELECT * " +
            "FROM PROFESSIONAL " +
            "WHERE TIEMPO_POR_CONSULTA_ID = :timeConsultationId", nativeQuery = true)
    List<Professional> getProfesionalByTimeConsultationId(@Param("timeConsultationId") Long timeConsultationId);


    @Query(value = "SELECT PROFESSIONAL_ID " +
                   "FROM DIA_LABORAL_POR_PROFESIONAL d " +
                   "WHERE DIA_LABORAL_ID = :workingDayId", nativeQuery = true)
    List<Long> getAllProfessionalIdByWorkingdayId(@Param("workingDayId") Long workingDayId);


    @Modifying
    @Query(value = "UPDATE PROFESSIONAL SET TIEMPO_POR_CONSULTA_ID = :timeConsultationId WHERE PROFESIONAL_ID = :professionalId", nativeQuery = true)
    void updateTimeConsultationForProfessional(@Param("professionalId") Long professionalId, @Param("timeConsultationId") Long timeConsultationId);


    @Modifying
    @Query(value = "UPDATE PROFESSIONAL " +
            "SET ESPECIALIDAD_ID = :specializationId " +
            "WHERE PROFESIONAL_ID = :professionalId", nativeQuery = true)
    void updateSpecializationForProfessional(@Param("professionalId") Long professionalId, @Param("specializationId") Long specializationId);

}
