package lk.vaccine.controller;

import lk.vaccine.entity.VaccineToken;
import lk.vaccine.service.VaccineTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "vaccine/" + "token")
public class VaccineTokenController {

    @Autowired
    private VaccineTokenService vaccineTokenService;

    @PostMapping(value = "/addToken")
    public ResponseEntity addToken(@RequestBody VaccineToken vaccineToken) {
        return ResponseEntity.ok(vaccineTokenService.addToken(vaccineToken));
    }

    @PutMapping(value = "/updateToken/{vaccineTokenId}")
    public ResponseEntity updateToken(@PathVariable String vaccineTokenId, @RequestBody VaccineToken vaccineToken) {
        return ResponseEntity.ok(vaccineTokenService.updateToken(vaccineTokenId, vaccineToken));
    }

    @DeleteMapping(value = "/deleteToken/{vaccineTokenId}")
    public ResponseEntity deleteToken(@PathVariable String vaccineTokenId) {
        return ResponseEntity.ok(vaccineTokenService.deleteToken(vaccineTokenId));
    }

    @GetMapping(value = "/getMyVaccines/{nic}")
    public ResponseEntity getMyVaccines(@PathVariable String nic) {
        return ResponseEntity.ok(vaccineTokenService.getMyVaccines(nic));
    }
}
