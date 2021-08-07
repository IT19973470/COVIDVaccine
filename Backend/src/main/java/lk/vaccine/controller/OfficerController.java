package lk.vaccine.controller;

import lk.vaccine.entity.Officer;
import lk.vaccine.entity.SubDivisionOfficer;
import lk.vaccine.entity.SubDivisionOfficerPK;
import lk.vaccine.entity.VaccineUser;
import lk.vaccine.service.OfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "vaccine/" + "officer")
public class OfficerController {

    @Autowired
    private OfficerService officerService;

    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody VaccineUser vaccineUser) {
        return ResponseEntity.ok(officerService.login(vaccineUser));
    }

    @PostMapping(value = "/addOfficer")
    public ResponseEntity addOfficer(@RequestBody Officer officer) {
        return ResponseEntity.ok(officerService.addOfficer(officer));
    }

    @PutMapping(value = "/updateOfficer/{officerId}")
    public ResponseEntity updateOfficer(@PathVariable String officerId, @RequestBody Officer officer) {
        return ResponseEntity.ok(officerService.updateOfficer(officerId, officer));
    }

    @DeleteMapping(value = "/deleteOfficer/{officerId}")
    public ResponseEntity deleteOfficer(@PathVariable String officerId) {
        return ResponseEntity.ok(officerService.deleteOfficer(officerId));
    }

    @PostMapping(value = "/addSubDivisionOfficer")
    public ResponseEntity addSubDivisionOfficer(@RequestBody SubDivisionOfficer subDivisionOfficer) {
        return ResponseEntity.ok(officerService.addSubDivisionOfficer(subDivisionOfficer));
    }

    @PutMapping(value = "/updateSubDivisionOfficer/{subDivisionId}/{officerId}")
    public ResponseEntity updateSubDivisionOfficer(@PathVariable String subDivisionId, @PathVariable String officerId, @RequestBody SubDivisionOfficer subDivisionOfficer) {
        return ResponseEntity.ok(officerService.updateSubDivisionOfficer(new SubDivisionOfficerPK(subDivisionId, officerId), subDivisionOfficer));
    }

    @DeleteMapping(value = "/deleteSubDivisionOfficer/{subDivisionId}/{officerId}")
    public ResponseEntity deleteSubDivisionOfficer(@PathVariable String subDivisionId, @PathVariable String officerId) {
        return ResponseEntity.ok(officerService.deleteSubDivisionOfficer(new SubDivisionOfficerPK(subDivisionId, officerId)));
    }

}

