package lk.vaccine.controller;

import lk.vaccine.entity.Place;
import lk.vaccine.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "vaccine/" + "place")
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

    @GetMapping(value = "getPlacesWIthPatients/{subDivisionId}/{tokenType}")
    public ResponseEntity getPlacesWIthPatients(@PathVariable String subDivisionId, @PathVariable int tokenType) {
        return ResponseEntity.ok(placeService.getPlacesWIthPatients(subDivisionId, tokenType));
    }

    @PostMapping(value = "/addPlace")
    public ResponseEntity addPlace(@RequestBody Place place) {
        return ResponseEntity.ok(placeService.addPlace(place));
    }

    @PutMapping(value = "/updatePlace/{placeId}")
    public ResponseEntity updatePlace(@PathVariable String placeId, @RequestBody Place place) {
        return ResponseEntity.ok(placeService.updatePlace(placeId, place));
    }

    @DeleteMapping(value = "/deletePlace/{placeId}")
    public ResponseEntity deletePlace(@PathVariable String placeId) {
        return ResponseEntity.ok(placeService.deletePlace(placeId));
    }
}
