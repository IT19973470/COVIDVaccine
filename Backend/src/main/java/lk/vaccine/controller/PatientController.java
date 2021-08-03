package lk.vaccine.controller;

import lk.vaccine.entity.Patient;
import lk.vaccine.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "vaccine/" + "patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping(value = "getVaccinatedCountForSubDivision/{subDivisionId}/{age}")
    public ResponseEntity getVaccinatedCountForSubDivision(@PathVariable String subDivisionId, @PathVariable int age) {
        return ResponseEntity.ok(patientService.getVaccinatedCountForSubDivision(subDivisionId, age));
    }

    @GetMapping(value = "getVaccinatedCountForDistrict/{districtId}/{age}")
    public ResponseEntity getVaccinatedCountForDistrict(@PathVariable String districtId, @PathVariable int age) {
        return ResponseEntity.ok(patientService.getVaccinatedCountForDistrict(districtId, age));
    }

    @GetMapping(value = "getVaccinatedCountForProvince/{provinceId}/{age}")
    public ResponseEntity getVaccinatedCountForProvince(@PathVariable String provinceId, @PathVariable int age) {
        return ResponseEntity.ok(patientService.getVaccinatedCountForProvince(provinceId, age));
    }

    @GetMapping(value = "getVaccinatedCountForCountry/{age}")
    public ResponseEntity getVaccinatedCountForCountry(@PathVariable int age) {
        return ResponseEntity.ok(patientService.getVaccinatedCountForCountry(age));
    }

    @PostMapping(value = "/addPatient")
    public ResponseEntity addPatient(@RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.addPatient(patient));
    }

    @PutMapping(value = "/updatePatient/{patientId}")
    public ResponseEntity updatePatient(@PathVariable String patientId, @RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.updatePatient(patientId, patient));
    }

    @DeleteMapping(value = "/deletePatient/{patientId}")
    public ResponseEntity deletePatient(@PathVariable String patientId) {
        return ResponseEntity.ok(patientService.deletePatient(patientId));
    }
}
