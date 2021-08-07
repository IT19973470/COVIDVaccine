package lk.vaccine.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class VaccineToken {

    @Id
    private String tokenId;

    @ManyToOne(fetch = FetchType.LAZY)
//    @MapsId("subDivisionOfficerId")
    @JoinColumns({
            @JoinColumn(name = "subDivisionId", referencedColumnName = "subDivisionId", updatable = false, nullable = false),
            @JoinColumn(name = "officerId", referencedColumnName = "officerId", updatable = false, nullable = false)
    })
    private SubDivisionOfficer subDivisionOfficer;

    @ManyToOne(fetch = FetchType.LAZY)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    private Place place;

    @ManyToOne(fetch = FetchType.LAZY)
    private Vaccine vaccine;

    private LocalDateTime tokenDateTime;
    private int tokenType;
    private boolean vaccinated;

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public SubDivisionOfficer getSubDivisionOfficer() {
        return subDivisionOfficer;
    }

    public void setSubDivisionOfficer(SubDivisionOfficer subDivisionOfficer) {
        this.subDivisionOfficer = subDivisionOfficer;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
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

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }
}
