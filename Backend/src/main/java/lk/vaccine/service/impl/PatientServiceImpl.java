package lk.vaccine.service.impl;

import lk.vaccine.dto.PatientDTO;
import lk.vaccine.dto.SubDivisionDTO;
import lk.vaccine.entity.Patient;
import lk.vaccine.entity.SubDivision;
import lk.vaccine.repository.PatientRepository;
import lk.vaccine.repository.PlaceRepository;
import lk.vaccine.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PlaceRepository placeRepository;


    @Override
    public List<SubDivisionDTO> getVaccinatedCountForSubDivision(String districtId, int age) {
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
        return subDivisionDTOS;
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
}
