package lk.vaccine.service;

import lk.vaccine.dto.*;
import lk.vaccine.entity.Place;

import java.util.List;

public interface PlaceService {

    List<ProvinceDTO> getProvinces();

    List<DistrictDTO> getDistricts(String provinceId);

    List<SubDivisionDTO> getSubDivisions(String districtId);

    PlaceDTO addPlace(Place place);

    PlaceDTO updatePlace(String placeId, Place place);

    boolean deletePlace(String placeId);

//    PlacePatientDTO getPlacesWIthPatients(String subDivisionId, int tokenType);

    List<PlaceDTO> getPlaces(String subDivisionId);
}
