package lk.vaccine.service.impl;

import lk.vaccine.dto.DistrictDTO;
import lk.vaccine.dto.PlaceDTO;
import lk.vaccine.dto.ProvinceDTO;
import lk.vaccine.dto.SubDivisionDTO;
import lk.vaccine.entity.District;
import lk.vaccine.entity.Place;
import lk.vaccine.entity.Province;
import lk.vaccine.entity.SubDivision;
import lk.vaccine.repository.DistrictRepository;
import lk.vaccine.repository.ProvinceRepository;
import lk.vaccine.repository.SubDivisionRepository;
import lk.vaccine.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private DistrictRepository districtRepository;
    @Autowired
    private SubDivisionRepository subDivisionRepository;

    @Override
    public List<ProvinceDTO> getProvinces() {
        List<Province> provinceList = provinceRepository.findAll();
        List<ProvinceDTO> provinceDTOS = new ArrayList<>();
        for (Province province : provinceList) {
            provinceDTOS.add(new ProvinceDTO(province));
        }
        return provinceDTOS;
    }

    @Override
    public List<DistrictDTO> getDistricts(String provinceId) {
        List<District> districtList = districtRepository.findAllByProvinceProvinceId(provinceId);
        List<DistrictDTO> districtDTOS = new ArrayList<>();
        for (District district : districtList) {
            districtDTOS.add(new DistrictDTO(district));
        }
        return districtDTOS;
    }

    @Override
    public List<SubDivisionDTO> getSubDivisions(String districtId) {
        List<SubDivision> subDivisionList = subDivisionRepository.findAllByDistrictDistrictId(districtId);
        List<SubDivisionDTO> subDivisionDTOS = new ArrayList<>();
        for (SubDivision subDivision : subDivisionList) {
            subDivisionDTOS.add(new SubDivisionDTO(subDivision));
        }
        return subDivisionDTOS;
    }

    @Override
    public PlaceDTO addPlace(Place place) {
        return null;
    }

    @Override
    public PlaceDTO updatePlace(String placeId, Place place) {
        return null;
    }

    @Override
    public PlaceDTO deletePlace(String placeId) {
        return null;
    }
}
