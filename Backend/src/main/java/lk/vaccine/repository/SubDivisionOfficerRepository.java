package lk.vaccine.repository;

import lk.vaccine.entity.SubDivisionOfficer;
import lk.vaccine.entity.SubDivisionOfficerPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubDivisionOfficerRepository extends JpaRepository<SubDivisionOfficer, SubDivisionOfficerPK> {

    List<SubDivisionOfficer> findAllBySubDivisionSubDivisionId(String subDivisionId);

}
