package lk.vaccine.entity;

import javax.persistence.*;

@Entity
public class Patient {

    @Id
    private String patientId;

    @OneToOne
    private VaccineUser vaccineUser;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private SubDivision subDivision;

    @OneToOne
    private Vaccine vaccine;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public VaccineUser getVaccineUser() {
        return vaccineUser;
    }

    public void setVaccineUser(VaccineUser vaccineUser) {
        this.vaccineUser = vaccineUser;
    }

    public SubDivision getSubDivision() {
        return subDivision;
    }

    public void setSubDivision(SubDivision subDivision) {
        this.subDivision = subDivision;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }
}
