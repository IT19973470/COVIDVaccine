package lk.covid.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Province {

    @Id
    private String provinceId;
    private String provinceName;

    public Province() {
    }

    public Province(String provinceId, String provinceName) {
        this.provinceId = provinceId;
        this.provinceName = provinceName;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
}
