package lk.vaccine.controller;

import lk.vaccine.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "place")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @GetMapping(value = "getProvinces")
    public ResponseEntity getProvinces() {
        return ResponseEntity.ok(placeService.getProvinces());
    }

    @GetMapping(value = "getDistricts/{provinceId}")
    public ResponseEntity getDistricts(@PathVariable String provinceId) {
        return ResponseEntity.ok(placeService.getDistricts(provinceId));
    }

    @GetMapping(value = "getSubDivisions/{districtId}")
    public ResponseEntity getSubDivisions(@PathVariable String districtId) {
        return ResponseEntity.ok(placeService.getSubDivisions(districtId));
    }
}
