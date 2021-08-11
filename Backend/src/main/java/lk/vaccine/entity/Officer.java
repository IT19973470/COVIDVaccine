package lk.vaccine.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Officer {

    @Id
    private String officerId;
    private String firstName;
    private String lastName;
    @OneToOne
    private VaccineUser vaccineUser;

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
