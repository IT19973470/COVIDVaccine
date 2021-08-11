package lk.vaccine.service.impl;

import lk.vaccine.dto.*;
import lk.vaccine.entity.*;
import lk.vaccine.repository.*;
import lk.vaccine.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private VaccineTokenRepository vaccineTokenRepository;
    @Autowired
    private VaccineRepository vaccineRepository;
    @Autowired
    private SubDivisionRepository subDivisionRepository;

    @Override
    public PlacePatientDTO getVaccinatedCountForIslandWide() {
        PlacePatientDTO placePatientDTO = new PlacePatientDTO();

        List<Patient> patientList = patientRepository.findAll();
        List<VaccineToken> vaccineTokenList = vaccineTokenRepository.findAll();
        List<SubDivision> subDivisions = subDivisionRepository.findAll();

        List<SubDivisionDTO> subDivisionDTOS = new ArrayList<>();
        int registered = 0, vaccinated = 0;

        for (SubDivision division : subDivisions) {

            for (Patient patient : patientList) {
                if (division.getSubDivisionName().equals(patient.getSubDivision().getSubDivisionName())) {
                    registered++;
                    if (patient.isVaccined()) {
                        vaccinated++;
                    }
                }
            }

            subDivisionDTOS.add(new SubDivisionDTO(division, registered, vaccinated));
            registered = 0;
            vaccinated = 0;
        }

        setVaccines(vaccineTokenList, placePatientDTO);

        placePatientDTO.setSubDivisions(subDivisionDTOS);


        return placePatientDTO;
    }


    @Override
    public PlacePatientDTO getVaccinatedCountForSubDivision(String districtId) {
        PlacePatientDTO placePatientDTO = new PlacePatientDTO();

        List<Patient> patientList = patientRepository.findAllBySubDivisionDistrictDistrictId(districtId);
        List<VaccineToken> vaccineTokenList = vaccineTokenRepository.getVaccineTokensByDistrict(districtId);
        List<SubDivision> subDivisions = subDivisionRepository.findAllByDistrictDistrictId(districtId);

//        Map<String, SubDivision> divisionsSet = new HashMap<>();
        List<SubDivisionDTO> subDivisionDTOS = new ArrayList<>();
        int registered = 0, vaccinated = 0;

//        for (Patient patient : patientList) {
//            divisionsSet.put(patient.getSubDivision().getSubDivisionName(), patient.getSubDivision());
//        }

        for (SubDivision division : subDivisions) {

            for (Patient patient : patientList) {
                if (division.getSubDivisionName().equals(patient.getSubDivision().getSubDivisionName())) {
                    registered++;
                    if (patient.isVaccined()) {
                        vaccinated++;
                    }
                }
            }

            subDivisionDTOS.add(new SubDivisionDTO(division, registered, vaccinated));
            registered = 0;
            vaccinated = 0;
        }

        setVaccines(vaccineTokenList, placePatientDTO);

        placePatientDTO.setSubDivisions(subDivisionDTOS);


        return placePatientDTO;
    }

    @Override
    public List<PatientDTO> getVaccinatedCountForDistrict(String districtId, int age) {
        return null;
    }

    @Override
    public List<PatientDTO> getVaccinatedCountForProvince(String provinceId, int age) {
        return null;
    }

    @Override
    public List<PatientDTO> getVaccinatedCountForCountry(int age) {
        return null;
    }

    @Override
    public PatientDTO addPatient(Patient patient) {
        return new PatientDTO(patientRepository.save(patient));
    }

    @Override
    public PatientDTO updatePatient(String patientId, Patient patient) {
        return null;
    }

    @Override
    public PatientDTO deletePatient(String patientId) {
        patientRepository.deleteById(patientId);
        return new PatientDTO(patientId);
    }

    @Override
    public PlacePatientDTO getPatientsCountForPlace(String subDivisionId, int tokenType) {
        List<VaccineToken> vaccineTokenList = vaccineTokenRepository.getVaccineTokensBySubDivision(subDivisionId);

        PlacePatientDTO placePatientDTO = new PlacePatientDTO();
        setVaccines(vaccineTokenList, placePatientDTO);

        return placePatientDTO;
    }

    @Override
    public List<PatientDTO> getPatientsForPlace(String subDivisionId, int tokenType, int age) {
        List<Patient> patientList = patientRepository.getPatientsByAge(subDivisionId, age);
        List<VaccineToken> vaccineTokenList = vaccineTokenRepository.getVaccineTokensBySubDivision(subDivisionId);

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
        return patientDTOS;
    }

    private void setVaccines(List<VaccineToken> vaccineTokenList, PlacePatientDTO placePatientDTO) {
        List<VaccineDTO> vaccineDTOSFirst = new ArrayList<>();
        List<VaccineDTO> vaccineDTOSSecond = new ArrayList<>();
        List<Vaccine> vaccines = vaccineRepository.findAll();

        VaccineDTO vaccineDTOs[];

        Map<String, VaccineDTO[]> stringVaccineMap = new HashMap<>();

        for (Vaccine vaccine : vaccines) {
            vaccineDTOs = new VaccineDTO[2];
            vaccineDTOs[0] = new VaccineDTO(vaccine);
            vaccineDTOs[1] = new VaccineDTO(vaccine);
            stringVaccineMap.put(vaccine.getVaccineName(), vaccineDTOs);
        }

        int registeredFirst = 0, vaccinatedFirst = 0, registeredSecond = 0, vaccinatedSecond = 0;

        for (Map.Entry<String, VaccineDTO[]> vaccine : stringVaccineMap.entrySet()) {

            for (VaccineToken vaccineToken : vaccineTokenList) {
                if (vaccine.getValue()[0].getVaccineName().equals(vaccineToken.getVaccine().getVaccineName()) && vaccineToken.getTokenType() == 1) {
                    registeredFirst++;
                    if (vaccineToken.isVaccinated()) {
                        vaccinatedFirst++;
                    }
                    VaccineDTO vaccineDTO = vaccine.getValue()[0];
                    vaccineDTO.setRegistered(registeredFirst);
                    vaccineDTO.setVaccinated(vaccinatedFirst);
//                    vaccineDTOSFirst.add(vaccineDTO);
                }

                if (vaccine.getValue()[1].getVaccineName().equals(vaccineToken.getVaccine().getVaccineName()) && vaccineToken.getTokenType() == 2) {
                    registeredSecond++;
                    if (vaccineToken.isVaccinated()) {
                        vaccinatedSecond++;
                    }
                    VaccineDTO vaccineDTO = vaccine.getValue()[1];
                    vaccineDTO.setRegistered(registeredSecond);
                    vaccineDTO.setVaccinated(vaccinatedSecond);
                }
            }

            vaccineDTOSFirst.add(vaccine.getValue()[0]);
            vaccineDTOSSecond.add(vaccine.getValue()[1]);

            registeredFirst = 0;
            registeredSecond = 0;
            vaccinatedFirst = 0;
            vaccinatedSecond = 0;
        }

        placePatientDTO.setVaccinesFirst(vaccineDTOSFirst);
        placePatientDTO.setVaccinesSecond(vaccineDTOSSecond);
    }
}
