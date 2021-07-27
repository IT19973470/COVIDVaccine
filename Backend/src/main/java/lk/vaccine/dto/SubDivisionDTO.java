package lk.vaccine.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lk.vaccine.entity.SubDivision;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubDivisionDTO {

    private String subDivisionId;
    private String subDivisionName;
    private DistrictDTO district;

    public SubDivisionDTO(SubDivision subDivision) {
        if (subDivision != null) {
            this.subDivisionId = subDivision.getSubDivisionId();
            this.subDivisionName = subDivision.getSubDivisionName();
        }
    }

    public SubDivisionDTO(SubDivision subDivision, DistrictDTO district) {
        this(subDivision);
        this.district = district;
    }

    public String getSubDivisionId() {
        return subDivisionId;
    }

    public void setSubDivisionId(String subDivisionId) {
        this.subDivisionId = subDivisionId;
    }

    public String getSubDivisionName() {
        return subDivisionName;
    }

    public void setSubDivisionName(String subDivisionName) {
        this.subDivisionName = subDivisionName;
    }

    public DistrictDTO getDistrict() {
        return district;
    }

    public void setDistrict(DistrictDTO district) {
        this.district = district;
    }
}
