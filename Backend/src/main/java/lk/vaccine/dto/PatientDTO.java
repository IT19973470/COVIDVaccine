package lk.vaccine.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lk.vaccine.entity.Patient;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PatientDTO {

    private String patientId;
    private String firstName;
    private String lastName;
    private String contactNumber;
    private String address;
    private String type;
    private boolean vaccined;
    private LocalDate dateOfBirth;
    private SubDivisionDTO subDivision;
    private VaccineDTO vaccineExpecting;
    private VaccineDTO vaccine;
    private String tokenId;
    private boolean registered;
    private PlaceDTO place;

    public PatientDTO(String patientId) {
        this.patientId = patientId;
    }

    public PatientDTO(Patient patient) {
        if (patient != null) {
            this.patientId = patient.getPatientId();
            this.firstName = patient.getFirstName();
            this.lastName = patient.getLastName();
            this.contactNumber = patient.getContactNumber();
            this.address = patient.getAddress();
            this.type = patient.getType();
            this.dateOfBirth = patient.getDateOfBirth();
            this.vaccined = patient.isVaccined();
        }
    }

    public PatientDTO(Patient patient, VaccineDTO vaccine) {
        this(patient);
        this.vaccineExpecting = vaccine;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public SubDivisionDTO getSubDivision() {
        return subDivision;
    }

    public void setSubDivision(SubDivisionDTO subDivision) {
        this.subDivision = subDivision;
    }

    public VaccineDTO getVaccine() {
        return vaccine;
    }

    public void setVaccine(VaccineDTO vaccine) {
        this.vaccine = vaccine;
    }

    public boolean isVaccined() {
        return vaccined;
    }

    public void setVaccined(boolean vaccined) {
        this.vaccined = vaccined;
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public PlaceDTO getPlace() {
        return place;
    }

    public void setPlace(PlaceDTO place) {
        this.place = place;
    }

    public VaccineDTO getVaccineExpecting() {
        return vaccineExpecting;
    }

    public void setVaccineExpecting(VaccineDTO vaccineExpecting) {
        this.vaccineExpecting = vaccineExpecting;
    }
}
