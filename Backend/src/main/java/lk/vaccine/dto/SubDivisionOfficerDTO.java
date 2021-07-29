package lk.vaccine.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lk.vaccine.entity.SubDivisionOfficer;
import lk.vaccine.entity.SubDivisionOfficerPK;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubDivisionOfficerDTO {

    private SubDivisionOfficerPK subDivisionOfficerId;
    private OfficerDTO officer;
    private SubDivisionDTO subDivision;

    public SubDivisionOfficerDTO(SubDivisionOfficer subDivisionOfficer) {
        if (subDivisionOfficer != null) {
            this.subDivisionOfficerId = subDivisionOfficer.getSubDivisionOfficerId();
        }
    }

    public SubDivisionOfficerDTO(SubDivisionOfficer subDivisionOfficer, SubDivisionDTO subDivision, OfficerDTO officer) {
        this(subDivisionOfficer);
        this.subDivision = subDivision;
        this.officer = officer;
    }

    public SubDivisionOfficerPK getSubDivisionOfficerId() {
        return subDivisionOfficerId;
    }

    public void setSubDivisionOfficerId(SubDivisionOfficerPK subDivisionOfficerId) {
        this.subDivisionOfficerId = subDivisionOfficerId;
    }

    public OfficerDTO getOfficer() {
        return officer;
    }

    public void setOfficer(OfficerDTO officer) {
        this.officer = officer;
    }

    public SubDivisionDTO getSubDivision() {
        return subDivision;
    }

    public void setSubDivision(SubDivisionDTO subDivision) {
        this.subDivision = subDivision;
    }
}
