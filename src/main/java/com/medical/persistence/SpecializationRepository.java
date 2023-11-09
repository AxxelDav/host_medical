package com.medical.persistence;

import com.medical.domain.model.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecializationRepository extends JpaRepository<Specialization, Long> {

    @Query(value = "SELECT * FROM " +
                   "ESPECIALIDAD WHERE DESCRIPCION= :specialization", nativeQuery = true)
    public Specialization findSpecializationByDescripcion(String specialization);

    @Query(value = "SELECT e.ESPECIALIDAD_ID, e.DESCRIPCION FROM ESPECIALIDAD e WHERE MODALIDAD_ID = :modalityId", nativeQuery = true)
    public List<Specialization> findAllSpecializationByModality(Long modalityId);

}