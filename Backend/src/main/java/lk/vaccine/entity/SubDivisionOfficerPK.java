package lk.vaccine.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SubDivisionOfficerPK implements Serializable {

    private String officerId;
    private String subDivisionId;

    public SubDivisionOfficerPK() {
    }

    public SubDivisionOfficerPK(String subDivisionId, String officerId) {
        this.officerId = officerId;
        this.subDivisionId = subDivisionId;
    }

    public String getOfficerId() {
        return officerId;
    }

    public void setOfficerId(String officerId) {
        this.officerId = officerId;
    }

    public String getSubDivisionId() {
        return subDivisionId;
    }

    public void setSubDivisionId(String subDivisionId) {
        this.subDivisionId = subDivisionId;
    }
}
