package lk.vaccine.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lk.vaccine.entity.Officer;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OfficerDTO {

    private String officerId;
    private String firstName;
    private String lastName;
    private VaccineUserDTO vaccineUser;

    public OfficerDTO(Officer officer) {
        if (officer != null) {
            this.officerId = officer.getOfficerId();
            this.firstName = officer.getFirstName();
            this.lastName = officer.getLastName();
        }
    }

    public OfficerDTO(Officer officer, VaccineUserDTO vaccineUser) {
        this(officer);
        this.vaccineUser = vaccineUser;
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

    public String getOfficerId() {
        return officerId;
    }

    public void setOfficerId(String officerId) {
        this.officerId = officerId;
    }

    public VaccineUserDTO getVaccineUser() {
        return vaccineUser;
    }

    public void setVaccineUser(VaccineUserDTO vaccineUser) {
        this.vaccineUser = vaccineUser;
    }
}
