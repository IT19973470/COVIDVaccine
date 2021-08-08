package lk.vaccine.service.impl;

import lk.vaccine.dto.*;
import lk.vaccine.entity.*;
import lk.vaccine.repository.PatientRepository;
import lk.vaccine.repository.PlaceRepository;
import lk.vaccine.repository.VaccineRepository;
import lk.vaccine.repository.VaccineTokenRepository;
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


    @Override
    public PlacePatientDTO getVaccinatedCountForSubDivision(String districtId, int age) {
        PlacePatientDTO placePatientDTO = new PlacePatientDTO();
        List<VaccineDTO> vaccineDTOSFirst = new ArrayList<>();
        List<VaccineDTO> vaccineDTOSSecond = new ArrayList<>();
        List<Vaccine> vaccines = vaccineRepository.findAll();
        List<VaccineToken> vaccineTokenList = vaccineTokenRepository.getVaccineTokensByDistrict(districtId);
        int registeredFirst = 0, vaccinatedFirst = 0, registeredSecond = 0, vaccinatedSecond = 0;
        List<Patient> patientList = patientRepository.findAllBySubDivisionDistrictDistrictId(districtId);

        Map<String, SubDivision> divisionsSet = new HashMap<>();
        List<SubDivisionDTO> subDivisionDTOS = new ArrayList<>();
//        Map<String, Integer[]> divisions = new HashMap<>();
        int registered = 0, vaccinated = 0;

        for (Patient patient : patientList) {
            divisionsSet.put(patient.getSubDivision().getSubDivisionName(), patient.getSubDivision());
        }

        for (Map.Entry<String, SubDivision> division : divisionsSet.entrySet()) {

            for (Patient patient : patientList) {
                if (division.getKey().equals(patient.getSubDivision().getSubDivisionName())) {
                    registered++;
                    if (patient.isVaccined()) {
                        vaccinated++;
                    }
                }
            }

            subDivisionDTOS.add(new SubDivisionDTO(division.getValue(), registered, vaccinated));
            registered = 0;
            vaccinated = 0;
        }

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
            registeredFirst = 0;
            registeredSecond = 0;
            vaccinatedFirst = 0;
            vaccinatedSecond = 0;
        }

        placePatientDTO.setSubDivisions(subDivisionDTOS);
        placePatientDTO.setVaccinesFirst(vaccineDTOSFirst);
        placePatientDTO.setVaccinesSecond(vaccineDTOSSecond);

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
        List<VaccineDTO> vaccineDTOSFirst = new ArrayList<>();
        List<VaccineDTO> vaccineDTOSSecond = new ArrayList<>();
        List<Vaccine> vaccines = vaccineRepository.findAll();
        List<VaccineToken> vaccineTokenList = vaccineTokenRepository.getVaccineTokensBySubDivision(subDivisionId);
        int registeredFirst = 0, vaccinatedFirst = 0, registeredSecond = 0, vaccinatedSecond = 0;
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
            registeredFirst = 0;
            registeredSecond = 0;
            vaccinatedFirst = 0;
            vaccinatedSecond = 0;
        }

        PlacePatientDTO placePatientDTO = new PlacePatientDTO();

        placePatientDTO.setVaccinesFirst(vaccineDTOSFirst);
        placePatientDTO.setVaccinesSecond(vaccineDTOSSecond);

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
}
