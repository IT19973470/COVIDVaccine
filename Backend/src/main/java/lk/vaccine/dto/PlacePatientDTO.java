package lk.vaccine.dto;

import java.util.List;

public class PlacePatientDTO {

    List<PlaceDTO> places;
    List<PatientDTO> patients;

    public List<PlaceDTO> getPlaces() {
        return places;
    }

    public void setPlaces(List<PlaceDTO> places) {
        this.places = places;
    }

    public List<PatientDTO> getPatients() {
        return patients;
    }

    public void setPatients(List<PatientDTO> patients) {
        this.patients = patients;
    }
}
