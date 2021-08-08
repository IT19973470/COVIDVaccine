package lk.vaccine.service.impl;

import lk.vaccine.dto.PlaceDTO;
import lk.vaccine.dto.VaccineDTO;
import lk.vaccine.entity.Place;
import lk.vaccine.entity.Vaccine;
import lk.vaccine.repository.VaccineRepository;
import lk.vaccine.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VaccineServiceImpl implements VaccineService {

    @Autowired
    private VaccineRepository vaccineRepository;

    @Override
    public VaccineDTO addVaccine(Vaccine vaccine) {
        LocalDateTime localDateTime = LocalDateTime.now();
        vaccine.setVaccineId(vaccine.getVaccineName() + localDateTime.format(DateTimeFormatter.ofPattern("hhmmss")));
        return new VaccineDTO(vaccineRepository.save(vaccine));
    }

    @Override
    public VaccineDTO updateVaccine(String vaccineId, Vaccine vaccine) {
        Optional<Vaccine> optionalVaccine = vaccineRepository.findById(vaccineId);
        if (optionalVaccine.isPresent()) {
            Vaccine vaccineObj = optionalVaccine.get();
            vaccineObj.setVaccineName(vaccine.getVaccineName());
            return new VaccineDTO(vaccineRepository.save(vaccineObj));
        }
        return null;
    }

    @Override
    public boolean deleteVaccine(String vaccineId) {
        vaccineRepository.deleteById(vaccineId);
        return true;
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
