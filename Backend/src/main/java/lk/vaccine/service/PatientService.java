package lk.vaccine.service;

import lk.vaccine.dto.PatientDTO;
import lk.vaccine.entity.Patient;

import java.util.List;

public interface PatientService {

    List<PatientDTO> getVaccinatedCountForSubDivision(String subDivisionId, int age);

    List<PatientDTO> getVaccinatedCountForDistrict(String districtId, int age);

    List<PatientDTO> getVaccinatedCountForProvince(String provinceId, int age);

    List<PatientDTO> getVaccinatedCountForCountry(int age);

    PatientDTO addPatient(Patient patient);

    PatientDTO updatePatient(String patientId, Patient patient);

    PatientDTO deletePatient(String patientId);
}
