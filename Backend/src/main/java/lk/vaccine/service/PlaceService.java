package lk.vaccine.service;

import lk.vaccine.dto.DistrictDTO;
import lk.vaccine.dto.PlaceDTO;
import lk.vaccine.dto.ProvinceDTO;
import lk.vaccine.dto.SubDivisionDTO;
import lk.vaccine.entity.Place;

import java.util.List;

public interface PlaceService {

    List<ProvinceDTO> getProvinces();

    List<DistrictDTO> getDistricts(String provinceId);

    List<SubDivisionDTO> getSubDivisions(String districtId);

    PlaceDTO addPlace(Place place);

    PlaceDTO updatePlace(String placeId, Place place);

    PlaceDTO deletePlace(String placeId);

    List<PlaceDTO> getPlaces(String subDivisionId);
}