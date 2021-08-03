package lk.vaccine.service.impl;

import lk.vaccine.dto.VaccineDTO;
import lk.vaccine.entity.Vaccine;
import lk.vaccine.repository.VaccineRepository;
import lk.vaccine.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VaccineServiceImpl implements VaccineService {

    @Autowired
    private VaccineRepository vaccineRepository;

    @Override
    public VaccineDTO addVaccine(Vaccine vaccine) {
        return null;
    }

    @Override
    public VaccineDTO updateVaccine(String vaccineId, Vaccine vaccine) {
        return null;
    }

    @Override
    public VaccineDTO deleteVaccine(String vaccineId) {
        return null;
    }

    @Override
    public List<VaccineDTO> getVaccines() {
        List<Vaccine> vaccines = vaccineRepository.findAll();
        List<VaccineDTO> vaccineDTOS = new ArrayList<>();
        for (Vaccine vaccine : vaccines) {
            vaccineDTOS.add(new VaccineDTO(vaccine));
        }
        return vaccineDTOS;
    }
}
