package lk.vaccine.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class District {

    @Id
    private String districtId;
    private String districtName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Province province;

    public District() {
    }

    public District(String districtId, String districtName, Province province) {
        this.districtId = districtId;
        this.districtName = districtName;
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

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}
