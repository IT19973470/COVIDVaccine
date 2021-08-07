package lk.vaccine.dto;

import java.util.List;

public class PlacePatientDTO {

    private List<PlaceDTO> places;
    private List<PatientDTO> patients;
    private List<VaccineDTO> vaccines;

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

    public List<VaccineDTO> getVaccines() {
        return vaccines;
    }

    public void setVaccines(List<VaccineDTO> vaccines) {
        this.vaccines = vaccines;
    }
}
