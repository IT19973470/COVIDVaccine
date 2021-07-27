package lk.vaccine.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lk.vaccine.entity.Province;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProvinceDTO {

    private String provinceId;
    private String provinceName;

    public ProvinceDTO(Province province) {
        if (province != null) {
            this.provinceId = province.getProvinceId();
            this.provinceName = province.getProvinceName();
        }
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
