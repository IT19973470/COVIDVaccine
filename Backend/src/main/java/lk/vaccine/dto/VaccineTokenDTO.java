package lk.vaccine.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lk.vaccine.entity.VaccineToken;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VaccineTokenDTO {

    private String tokenId;
    private SubDivisionOfficerDTO subDivisionOfficer;
    private PatientDTO patient;
    private PlaceDTO place;
    private LocalDateTime tokenDateTime;
    private String tokenDateTimeFormattedDate;
    private String tokenDateTimeFormattedTime;
    private VaccineDTO vaccine;
    private int tokenType;

    public VaccineTokenDTO(VaccineToken vaccineToken) {
        if (vaccineToken != null) {
            this.tokenId = vaccineToken.getTokenId();
            this.tokenDateTime = vaccineToken.getTokenDateTime();
            this.tokenType = vaccineToken.getTokenType();
            this.tokenDateTimeFormattedDate = vaccineToken.getTokenDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            this.tokenDateTimeFormattedTime = vaccineToken.getTokenDateTime().format(DateTimeFormatter.ofPattern("hh:mm a"));
        }
    }

    public VaccineTokenDTO(VaccineToken vaccineToken, VaccineDTO vaccine, PlaceDTO place) {
        this(vaccineToken);
        this.vaccine = vaccine;
        this.place = place;
    }

    public VaccineTokenDTO(VaccineToken vaccineToken, SubDivisionOfficerDTO subDivisionOfficer, PatientDTO patient, PlaceDTO place, VaccineDTO vaccine) {
        this(vaccineToken);
        this.subDivisionOfficer = subDivisionOfficer;
        this.patient = patient;
        this.place = place;
        this.vaccine = vaccine;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public SubDivisionOfficerDTO getSubDivisionOfficer() {
        return subDivisionOfficer;
    }

    public void setSubDivisionOfficer(SubDivisionOfficerDTO subDivisionOfficer) {
        this.subDivisionOfficer = subDivisionOfficer;
    }

    public PatientDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }

    public PlaceDTO getPlace() {
        return place;
    }

    public void setPlace(PlaceDTO place) {
        this.place = place;
    }

    public LocalDateTime getTokenDateTime() {
        return tokenDateTime;
    }

    public void setTokenDateTime(LocalDateTime tokenDateTime) {
        this.tokenDateTime = tokenDateTime;
    }

    public int getTokenType() {
        return tokenType;
    }

    public void setTokenType(int tokenType) {
        this.tokenType = tokenType;
    }

    public VaccineDTO getVaccine() {
        return vaccine;
    }

    public void setVaccine(VaccineDTO vaccine) {
        this.vaccine = vaccine;
    }

    public String getTokenDateTimeFormattedDate() {
        return tokenDateTimeFormattedDate;
    }

    public void setTokenDateTimeFormattedDate(String tokenDateTimeFormattedDate) {
        this.tokenDateTimeFormattedDate = tokenDateTimeFormattedDate;
    }

    public String getTokenDateTimeFormattedTime() {
        return tokenDateTimeFormattedTime;
    }

    public void setTokenDateTimeFormattedTime(String tokenDateTimeFormattedTime) {
        this.tokenDateTimeFormattedTime = tokenDateTimeFormattedTime;
    }
}
