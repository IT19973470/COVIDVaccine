package lk.vaccine.repository;

import lk.vaccine.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, String> {

    List<Patient> findAllBySubDivisionDistrictDistrictId(String districtId);

    List<Patient> findAllBySubDivisionSubDivisionId(String subDivisionId);

    @Query(value = "from Patient where subDivision.subDivisionId=?1 and (year(curdate()) - year(dateOfBirth))>=?2")
    List<Patient> getPatientsByAge(String subDivisionId, int age);

}
