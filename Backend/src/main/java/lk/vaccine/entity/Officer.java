package lk.vaccine.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Officer {

    @Id
    private String officerId;
    @OneToOne
    private VaccineUser vaccineUser;

    public String getOfficerId() {
        return officerId;
    }

    public void setOfficerId(String officerId) {
        this.officerId = officerId;
    }

    public VaccineUser getVaccineUser() {
        return vaccineUser;
    }

    public void setVaccineUser(VaccineUser vaccineUser) {
        this.vaccineUser = vaccineUser;
    }

}
