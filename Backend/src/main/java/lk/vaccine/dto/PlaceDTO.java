package lk.vaccine.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lk.vaccine.entity.Place;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlaceDTO {

    private String placeId;
    private String placeName;
    private String address;
    private SubDivisionDTO subDivision;
    private List<PatientDTO> patients;

    public PlaceDTO(Place place) {
        if (place != null) {
            this.placeId = place.getPlaceId();
            this.placeName = place.getPlaceName();
            this.address = place.getAddress();
        }
    }

    public PlaceDTO(Place place, SubDivisionDTO subDivision) {
        this(place);
        this.subDivision = subDivision;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public SubDivisionDTO getSubDivision() {
        return subDivision;
    }

    public void setSubDivision(SubDivisionDTO subDivision) {
        this.subDivision = subDivision;
    }

    public List<PatientDTO> getPatients() {
        return patients;
    }

    public void setPatients(List<PatientDTO> patients) {
        this.patients = patients;
    }
}
