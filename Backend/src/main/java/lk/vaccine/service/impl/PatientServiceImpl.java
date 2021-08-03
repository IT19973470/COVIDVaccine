package lk.vaccine.service.impl;

import lk.vaccine.dto.PatientDTO;
import lk.vaccine.entity.Patient;
import lk.vaccine.repository.PatientRepository;
import lk.vaccine.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;


    @Override
    public List<PatientDTO> getVaccinatedCountForSubDivision(String subDivisionId, int age) {
        return null;
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
