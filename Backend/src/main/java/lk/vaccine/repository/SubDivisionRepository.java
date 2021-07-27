package lk.vaccine.repository;

import lk.vaccine.entity.SubDivision;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubDivisionRepository extends JpaRepository<SubDivision, String> {

    List<SubDivision> findAllByDistrictDistrictId(String districtId);

}
