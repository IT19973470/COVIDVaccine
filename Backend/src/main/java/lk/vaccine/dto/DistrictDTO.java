package lk.vaccine.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lk.vaccine.entity.District;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DistrictDTO {

    private String districtId;
    private String districtName;
    private ProvinceDTO province;

    public DistrictDTO(District district) {
        if (district != null) {
            this.districtId = district.getDistrictId();
            this.districtName = district.getDistrictName();
        }
    }

    public DistrictDTO(District district, ProvinceDTO province) {
        this(district);
        this.province = province;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public ProvinceDTO getProvince() {
        return province;
    }

    public void setProvince(ProvinceDTO province) {
        this.province = province;
    }
}
