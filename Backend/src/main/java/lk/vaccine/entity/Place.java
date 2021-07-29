package lk.vaccine.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Place {

    @Id
    private String placeId;
    private String placeName;
    private String address;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private SubDivision subDivision;

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public SubDivision getSubDivision() {
        return subDivision;
    }

    public void setSubDivision(SubDivision subDivision) {
        this.subDivision = subDivision;
    }
}
