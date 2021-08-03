package lk.vaccine.controller;

import lk.vaccine.entity.Vaccine;
import lk.vaccine.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "vaccine/" + "vaccine")
public class VaccineController {

    @Autowired
    private VaccineService vaccineService;

    @PostMapping(value = "/addVaccine")
    public ResponseEntity addVaccine(@RequestBody Vaccine vaccine) {
        return ResponseEntity.ok(vaccineService.addVaccine(vaccine));
    }

    @PutMapping(value = "/updateVaccine/{vaccineId}")
    public ResponseEntity updateVaccine(@PathVariable String vaccineId, @RequestBody Vaccine vaccine) {
        return ResponseEntity.ok(vaccineService.updateVaccine(vaccineId, vaccine));
    }

    @DeleteMapping(value = "/deleteVaccine/{vaccineId}")
    public ResponseEntity deleteVaccine(@PathVariable String vaccineId) {
        return ResponseEntity.ok(vaccineService.deleteVaccine(vaccineId));
    }

    @GetMapping(value = "/getVaccines")
    public ResponseEntity getVaccines() {
        return ResponseEntity.ok(vaccineService.getVaccines());
    }
}
