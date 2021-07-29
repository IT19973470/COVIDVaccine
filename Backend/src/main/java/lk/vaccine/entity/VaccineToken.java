package lk.vaccine.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class VaccineToken {

    @Id
    private String tokenId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "officerId", referencedColumnName = "officerId", insertable = false, updatable = false, nullable = false),
            @JoinColumn(name = "subDivisionId", referencedColumnName = "subDivisionId", insertable = false, updatable = false, nullable = false)
    })
    private SubDivisionOfficer subDivisionOfficer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Place place;

    private LocalDate tokenDate;
    private int tokenType;

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

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
