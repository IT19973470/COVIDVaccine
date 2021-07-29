package lk.vaccine.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lk.vaccine.entity.VaccineToken;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VaccineTokenDTO {

    private String tokenId;
    private SubDivisionOfficerDTO subDivisionOfficer;
    private PatientDTO patient;
    private PlaceDTO place;
    private LocalDate tokenDate;
    private int tokenType;

    public VaccineTokenDTO(VaccineToken vaccineToken) {
        if (vaccineToken != null) {
            this.tokenId = vaccineToken.getTokenId();
            this.tokenDate = vaccineToken.getTokenDate();
            this.tokenType = vaccineToken.getTokenType();
        }
    }

    public VaccineTokenDTO(VaccineToken vaccineToken, SubDivisionOfficerDTO subDivisionOfficer, PatientDTO patient, PlaceDTO place) {
        this(vaccineToken);
        this.subDivisionOfficer = subDivisionOfficer;
        this.patient = patient;
        this.place = place;
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

    public LocalDate getTokenDate() {
        return tokenDate;
    }

    public void setTokenDate(LocalDate tokenDate) {
        this.tokenDate = tokenDate;
    }

    public int getTokenType() {
        return tokenType;
    }

    public void setTokenType(int tokenType) {
        this.tokenType = tokenType;
    }
}
