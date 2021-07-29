package lk.vaccine.service;

import lk.vaccine.dto.VaccineDTO;
import lk.vaccine.entity.Vaccine;

public interface VaccineService {

    VaccineDTO addVaccine(Vaccine vaccine);

    VaccineDTO updateVaccine(String vaccineId, Vaccine vaccine);

    VaccineDTO deleteVaccine(String vaccineId);
}
