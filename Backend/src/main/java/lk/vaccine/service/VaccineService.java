package lk.vaccine.service;

import lk.vaccine.dto.VaccineDTO;
import lk.vaccine.entity.Vaccine;

import java.util.List;

public interface VaccineService {

    VaccineDTO addVaccine(Vaccine vaccine);

    VaccineDTO updateVaccine(String vaccineId, Vaccine vaccine);

    VaccineDTO deleteVaccine(String vaccineId);

    List<VaccineDTO> getVaccines();

}
