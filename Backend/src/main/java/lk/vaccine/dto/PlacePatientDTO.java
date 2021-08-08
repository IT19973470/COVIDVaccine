package lk.vaccine.dto;

import java.util.List;

public class PlacePatientDTO {

    private List<PlaceDTO> places;
    private List<PatientDTO> patients;
    private List<VaccineDTO> vaccinesFirst;
    private List<VaccineDTO> vaccinesSecond;
    private List<SubDivisionDTO> subDivisions;

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

    public List<VaccineDTO> getVaccinesFirst() {
        return vaccinesFirst;
    }

    public void setVaccinesFirst(List<VaccineDTO> vaccinesFirst) {
        this.vaccinesFirst = vaccinesFirst;
    }

    public List<VaccineDTO> getVaccinesSecond() {
        return vaccinesSecond;
    }

    public void setVaccinesSecond(List<VaccineDTO> vaccinesSecond) {
        this.vaccinesSecond = vaccinesSecond;
    }

    public List<SubDivisionDTO> getSubDivisions() {
        return subDivisions;
    }

    public void setSubDivisions(List<SubDivisionDTO> subDivisions) {
        this.subDivisions = subDivisions;
    }
}
