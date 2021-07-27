package lk.vaccine.util;

import lk.vaccine.entity.District;
import lk.vaccine.entity.Province;
import lk.vaccine.entity.SubDivision;
import lk.vaccine.repository.SubDivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import lk.vaccine.repository.DistrictRepository;
import lk.vaccine.repository.ProvinceRepository;

@Component
public class InitDB {

    @Autowired
    private DistrictRepository districtRepository;
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private SubDivisionRepository subDivisionRepository;

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        if (provinceRepository.findAll().size() == 0 && districtRepository.findAll().size() == 0) {

            Province provinceSouthern = provinceRepository.save(new Province("P1", "Southern"));
            District districtGalle = districtRepository.save(new District("D1", "Galle", provinceSouthern));
            subDivisionRepository.save(new SubDivision("Galle1", "Ambalangoda", districtGalle));
            subDivisionRepository.save(new SubDivision("Galle1", "Rathgama", districtGalle));

            District districtMathara = districtRepository.save(new District("D3", "Mathara", provinceSouthern));
            subDivisionRepository.save(new SubDivision("Mathara1", "Makandura", districtMathara));
            subDivisionRepository.save(new SubDivision("Mathara1", "Yatiyana", districtMathara));

            District districtHambantota = districtRepository.save(new District("D4", "Hambantota", provinceSouthern));
            subDivisionRepository.save(new SubDivision("Hambantota1", "Katharagama", districtHambantota));
            subDivisionRepository.save(new SubDivision("Hambantota1", "Tangalle", districtHambantota));

            Province provinceWestern = provinceRepository.save(new Province("P2", "Western"));
            districtRepository.save(new District("D2", "Colombo", provinceWestern));

            Province provinceNothern = provinceRepository.save(new Province("P3", "Nothern"));
            districtRepository.save(new District("D5", "Jaffna", provinceNothern));

        }
    }

}
