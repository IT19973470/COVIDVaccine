package lk.vaccine.service;

import lk.vaccine.dto.PatientDTO;
import lk.vaccine.dto.SubDivisionDTO;
import lk.vaccine.entity.Patient;

import java.util.List;

public interface PatientService {

    List<SubDivisionDTO> getVaccinatedCountForSubDivision(String districtId, int age);

    List<PatientDTO> getVaccinatedCountForDistrict(String districtId, int age);

    List<PatientDTO> getVaccinatedCountForProvince(String provinceId, int age);

    List<PatientDTO> getVaccinatedCountForCountry(int age);

    PatientDTO addPatient(Patient patient);

    PatientDTO updatePatient(String patientId, Patient patient);

    PatientDTO deletePatient(String patientId);
}
