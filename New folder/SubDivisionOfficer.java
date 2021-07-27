package lk.covid.entity;

import javax.persistence.*;

@Entity
public class SubDivisionOfficer {

    @EmbeddedId
    private SubDivisionOfficerPK subDivisionOfficerId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "officerId", referencedColumnName = "officerId", insertable = false, updatable = false, nullable = false)
    private Officer officer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "subDivisionId", referencedColumnName = "subDivisionId", insertable = false, updatable = false, nullable = false)
    private SubDivision subDivision;

    public SubDivisionOfficerPK getSubDivisionOfficerId() {
        return subDivisionOfficerId;
    }

    public void setSubDivisionOfficerId(SubDivisionOfficerPK subDivisionOfficerId) {
        this.subDivisionOfficerId = subDivisionOfficerId;
    }

    public Officer getOfficer() {
        return officer;
    }

    public void setOfficer(Officer officer) {
        this.officer = officer;
    }

    public SubDivision getSubDivision() {
        return subDivision;
    }

    public void setSubDivision(SubDivision subDivision) {
        this.subDivision = subDivision;
    }
}
