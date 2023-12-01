package com.medical.persistence;

import com.medical.domain.model.MedicalBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalBranchRepository extends JpaRepository<MedicalBranch, Long> {


    @Query(value = "SELECT * " +
            "FROM SUCURSAL s " +
            "WHERE s.LOCALIDAD = :locale AND s.NUMERO = :streetNumber AND CALLE = :street", nativeQuery = true)
    public MedicalBranch findByLocaleAndNumberAndStreet(@Param("locale") String locale, @Param("streetNumber") String streetNumber, @Param("street") String street);


    @Query(value = "SELECT s.SUCURSAL_ID, s.LOCALIDAD, s.NUMERO, s.CALLE " +
            "FROM SUCURSAL s " +
            "INNER JOIN PROFESSIONAL p ON s.SUCURSAL_ID = p.SUCURSAL_ID " +
            "INNER JOIN ESPECIALIDAD e ON p.ESPECIALIDAD_ID = e.ESPECIALIDAD_ID " +
            "WHERE e.ESPECIALIDAD_ID = :specializationId", nativeQuery = true)
    public List<MedicalBranch> findMedicalBranchBySpecialization(@Param("specializationId") Long specializationId);


    @Query(value = "SELECT s.SUCURSAL_ID, s.LOCALIDAD, s.NUMERO, s.CALLE " +
            "FROM SUCURSAL s " +
            "INNER JOIN PROFESSIONAL p ON s.SUCURSAL_ID = p.SUCURSAL_ID " +
            "WHERE p.PROFESIONAL_ID = :professionalId", nativeQuery = true)
    public List<MedicalBranch> findMedicalBranchByProfessional(@Param("professionalId") Long professionalId);


}
