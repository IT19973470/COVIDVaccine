package lk.covid.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Patient {

    @Id
    private String patientId;
    @OneToOne
    private VaccineUser vaccineUser;

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
}
