package lk.vaccine.service.impl;

import lk.vaccine.dto.*;
import lk.vaccine.entity.*;
import lk.vaccine.repository.*;
import lk.vaccine.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private DistrictRepository districtRepository;
    @Autowired
    private SubDivisionRepository subDivisionRepository;
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private TimeSlotRepository timeSlotRepository;

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
        LocalDateTime localDateTime = LocalDateTime.now();
        place.setPlaceId(place.getPlaceName() + localDateTime.format(DateTimeFormatter.ofPattern("hhmmss")));
        return new PlaceDTO(placeRepository.save(place));
    }

    @Override
    public PlaceDTO updatePlace(String placeId, Place place) {
        Optional<Place> optionalPlace = placeRepository.findById(placeId);
        if (optionalPlace.isPresent()) {
            Place placeObj = optionalPlace.get();
            placeObj.setPlaceName(place.getPlaceName());
            placeObj.setAddress(place.getAddress());
            return new PlaceDTO(placeRepository.save(placeObj));
        }
        return null;
    }

    @Override
    public boolean deletePlace(String placeId) {
        placeRepository.deleteById(placeId);
        return true;
    }

    @Override
    public List<PlaceDTO> getPlaces(String subDivisionId) {
        List<Place> placeList = placeRepository.findAllBySubDivisionSubDivisionId(subDivisionId);

        List<PlaceDTO> placeDTOS = new ArrayList<>();
        for (Place place : placeList) {
            placeDTOS.add(new PlaceDTO(place));
        }

        return placeDTOS;
    }

    @Override
    public List<TimeSlot> getTimeSlots() {
        return timeSlotRepository.getTimeSlots();
    }
}
