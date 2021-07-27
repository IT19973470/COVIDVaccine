package lk.vaccine.repository;

import lk.vaccine.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistrictRepository extends JpaRepository<District, String> {

    List<District> findAllByProvinceProvinceId(String provinceId);

}
