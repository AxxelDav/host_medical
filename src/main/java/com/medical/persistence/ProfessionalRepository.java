package com.medical.persistence;

import com.medical.domain.model.Professional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessionalRepository extends JpaRepository<Professional, Long> {

    @Query(value = "SELECT * " +
            "FROM PROFESSIONAL " +
            "WHERE ESPECIALIDAD_ID = :specializationId", nativeQuery = true)
    List<Professional> getProfesionalBySpecializationId(Long specializationId);


    @Query(value = "SELECT * " +
            "FROM PROFESSIONAL " +
            "WHERE TURNO_LABORAL_ID = :workShiftId", nativeQuery = true)
    List<Professional> getProfessionalByWorkShiftId(Long workShiftId);


    @Query(value = "SELECT * " +
            "FROM PROFESSIONAL " +
            "WHERE TIEMPO_POR_CONSULTA_ID = :timeConsultationId", nativeQuery = true)
    List<Professional> getProfesionalByTimeConsultationId(Long timeConsultationId);


    @Query(value = "SELECT PROFESIONAL_ID " +
                   "FROM DIA_LABORAL_POR_PROFESIONAL d " +
                   "WHERE DIA_LABORAL_ID = :workingDayId", nativeQuery = true)
    List<Long> getAllProfessionalIdByWorkingdayId(Long workingDayId);


    @Query(value = "UPDATE PROFESIONAL " +
                   "SET TIEMPO_POR_CONSULTA_ID = :timeConsultationId " +
                   "WHERE PROFESIONAL_ID = :professionaId", nativeQuery = true)
    void updateTimeConsultation(Long professionaId, Long timeConsultationId);


    @Query(value = "UPDATE PROFESIONAL " +
            "SET ESPECIALIDAD_ID = :specializationId " +
            "WHERE PROFESIONAL_ID = :professionalId", nativeQuery = true)
    void updateSpecialization(Long professionalId, Long specializationId);



}
