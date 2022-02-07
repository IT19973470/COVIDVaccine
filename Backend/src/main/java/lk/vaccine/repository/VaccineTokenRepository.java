package lk.vaccine.repository;

import lk.vaccine.entity.VaccineToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface VaccineTokenRepository extends JpaRepository<VaccineToken, String> {

    @Query(value = "from VaccineToken where subDivisionOfficer.subDivision.subDivisionId=?1")
    List<VaccineToken> getVaccineTokensBySubDivision(String subDivisionId);

    @Query(value = "from VaccineToken where time(tokenDateTime)=time(?1) and subDivisionOfficer.subDivision.subDivisionId=?2")
    List<VaccineToken> getVaccineTokensByTime(LocalDateTime time, String subDivisionId);

    @Query(value = "from VaccineToken where subDivisionOfficer.subDivision.district.districtId=?1")
    List<VaccineToken> getVaccineTokensByDistrict(String districtId);

    List<VaccineToken> getAllByPatientPatientId(String nic);

    List<VaccineToken> getAllBySubDivisionOfficerSubDivisionSubDivisionId(String subDivisionId);

}
