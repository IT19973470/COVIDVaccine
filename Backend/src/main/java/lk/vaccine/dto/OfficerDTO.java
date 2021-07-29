package lk.vaccine.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lk.vaccine.entity.Officer;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OfficerDTO {

    private String officerId;
    private VaccineUserDTO vaccineUser;

    public OfficerDTO(Officer officer) {
        if (officer != null) {
            this.officerId = officer.getOfficerId();
        }
    }

    public OfficerDTO(Officer officer, VaccineUserDTO vaccineUser) {
        this(officer);
        this.vaccineUser = vaccineUser;
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
