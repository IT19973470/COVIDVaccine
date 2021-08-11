package lk.vaccine.service;

import lk.vaccine.dto.PatientDTO;
import lk.vaccine.dto.PlacePatientDTO;
import lk.vaccine.dto.SubDivisionDTO;
import lk.vaccine.entity.Patient;

import java.util.List;

public interface PatientService {

    PlacePatientDTO getVaccinatedCountForIslandWide();

    PlacePatientDTO getVaccinatedCountForSubDivision(String districtId);

    List<PatientDTO> getVaccinatedCountForDistrict(String districtId, int age);

    List<PatientDTO> getVaccinatedCountForProvince(String provinceId, int age);

    List<PatientDTO> getVaccinatedCountForCountry(int age);

    PatientDTO addPatient(Patient patient);

    PatientDTO updatePatient(String patientId, Patient patient);

    PatientDTO deletePatient(String patientId);

    List<PatientDTO> getPatientsForPlace(String subDivisionId, int tokenType, int age);

    PlacePatientDTO getPatientsCountForPlace(String subDivisionId, int tokenType);
}
