package lk.vaccine.repository;

import lk.vaccine.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, String> {

    List<Patient> findAllBySubDivisionDistrictDistrictId(String districtId);

    List<Patient> findAllBySubDivisionSubDivisionId(String subDivisionId);

}
