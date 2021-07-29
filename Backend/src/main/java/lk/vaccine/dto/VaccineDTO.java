package lk.vaccine.dto;

import lk.vaccine.entity.Vaccine;

public class VaccineDTO {

    private String vaccineId;
    private String vaccineName;

    public VaccineDTO(Vaccine vaccine) {
        if (vaccine != null) {
            this.vaccineId = vaccine.getVaccineId();
            this.vaccineName = vaccine.getVaccineName();
        }
    }

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
