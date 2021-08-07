package lk.vaccine.service.impl;

import lk.vaccine.dto.*;
import lk.vaccine.entity.*;
import lk.vaccine.repository.*;
import lk.vaccine.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private PatientRepository patientRepository;
    @Autowired
    private VaccineTokenRepository vaccineTokenRepository;
    @Autowired
    private VaccineRepository vaccineRepository;

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

    @Override
    public PlacePatientDTO getPlacesWIthPatients(String subDivisionId, int tokenType) {
        List<Place> placeList = placeRepository.findAllBySubDivisionSubDivisionId(subDivisionId);
        List<Patient> patientList = patientRepository.findAllBySubDivisionSubDivisionId(subDivisionId);
        List<VaccineToken> vaccineTokenList = vaccineTokenRepository.getVaccineTokensBySubDivision(subDivisionId);
        List<Vaccine> vaccines = vaccineRepository.findAll();
        int registeredFirst = 0, vaccinatedFirst = 0, registeredSecond = 0, vaccinatedSecond = 0;

        List<PatientDTO> patientDTOS = new ArrayList<>();
        for (Patient patient : patientList) {
            PatientDTO patientDTO = new PatientDTO(patient, new VaccineDTO(patient.getVaccine()));
            patientDTO.setRegistered(false);
            for (VaccineToken vaccineToken : vaccineTokenList) {
                if (vaccineToken.getPatient().getPatientId().equals(patient.getPatientId()) && vaccineToken.getTokenType() == tokenType) {
                    patientDTO.setTokenId(vaccineToken.getTokenId());
                    patientDTO.setPlace(new PlaceDTO(vaccineToken.getPlace()));
                    patientDTO.setVaccine(new VaccineDTO(vaccineToken.getVaccine()));
                    patientDTO.setRegistered(true);
                }
            }
            patientDTOS.add(patientDTO);
        }

        List<PlaceDTO> placeDTOS = new ArrayList<>();
        for (Place place : placeList) {
            placeDTOS.add(new PlaceDTO(place));
        }

        PlacePatientDTO placePatientDTO = new PlacePatientDTO();
        placePatientDTO.setPatients(patientDTOS);
        placePatientDTO.setPlaces(placeDTOS);

        List<VaccineDTO> vaccineDTOSFirst = new ArrayList<>();
        List<VaccineDTO> vaccineDTOSSecond = new ArrayList<>();
//        Map<String, VaccineToken> vaccineMap = new HashMap<>();
//        for (VaccineToken vaccineToken : vaccineTokenList) {
//            vaccineMap.put(vaccineToken.getPatient().getPatientId(), vaccineToken);
//        }

        for (Vaccine vaccine : vaccines) {

            for (VaccineToken vaccineToken : vaccineTokenList) {
                if (vaccine.getVaccineName().equals(vaccineToken.getVaccine().getVaccineName()) && vaccineToken.getTokenType() == 1) {
                    registeredFirst++;
                    if (vaccineToken.isVaccinated()) {
                        vaccinatedFirst++;
                    }
                    VaccineDTO vaccineDTO = new VaccineDTO(vaccineToken.getVaccine());
                    vaccineDTO.setRegistered(registeredFirst);
                    vaccineDTO.setVaccinated(vaccinatedFirst);
                    vaccineDTOSFirst.add(vaccineDTO);
                }

                if (vaccine.getVaccineName().equals(vaccineToken.getVaccine().getVaccineName()) && vaccineToken.getTokenType() == 2) {
                    registeredSecond++;
                    if (vaccineToken.isVaccinated()) {
                        vaccinatedSecond++;
                    }
                    VaccineDTO vaccineDTO = new VaccineDTO(vaccineToken.getVaccine());
                    vaccineDTO.setRegistered(registeredSecond);
                    vaccineDTO.setVaccinated(vaccinatedSecond);
                    vaccineDTOSSecond.add(vaccineDTO);
                }
            }
        }

        placePatientDTO.setVaccinesFirst(vaccineDTOSFirst);
        placePatientDTO.setVaccinesSecond(vaccineDTOSSecond);

        return placePatientDTO;
    }
}
