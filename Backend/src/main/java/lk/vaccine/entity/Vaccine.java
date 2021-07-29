package lk.vaccine.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vaccine {

    @Id
    private String vaccineId;
    private String vaccineName;

    public String getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(String vaccineId) {
        this.vaccineId = vaccineId;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }
}
