package lk.vaccine.service;

import lk.vaccine.dto.DistrictDTO;
import lk.vaccine.dto.ProvinceDTO;
import lk.vaccine.dto.SubDivisionDTO;

import java.util.List;

public interface PlaceService {

    List<ProvinceDTO> getProvinces();

    List<DistrictDTO> getDistricts(String provinceId);

    List<SubDivisionDTO> getSubDivisions(String districtId);
}
