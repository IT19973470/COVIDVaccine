package lk.vaccine.repository;

import lk.vaccine.entity.VaccineToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VaccineTokenRepository extends JpaRepository<VaccineToken, String> {

    @Query(value = "from VaccineToken where subDivisionOfficer.subDivision.subDivisionId=?1")
    List<VaccineToken> getVaccineTokensBySubDivision(String subDivisionId);

    @Query(value = "from VaccineToken where subDivisionOfficer.subDivision.district.districtId=?1")
    List<VaccineToken> getVaccineTokensByDistrict(String districtId);

    List<VaccineToken> getAllByPatientPatientId(String nic);

    List<VaccineToken> getAllBySubDivisionOfficerSubDivisionSubDivisionId(String subDivisionId);

}
