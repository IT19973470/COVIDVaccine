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

            Province provinceSouthern = provinceRepository.save(new Province("SP", "Southern"));
            District districtGalle = districtRepository.save(new District("Galle", "Galle", provinceSouthern));
            subDivisionRepository.save(new SubDivision("Ambalangoda", "Ambalangoda", districtGalle));
            subDivisionRepository.save(new SubDivision("Rathgama", "Rathgama", districtGalle));

            District districtMathara = districtRepository.save(new District("Mathara", "Mathara", provinceSouthern));
            subDivisionRepository.save(new SubDivision("Makandura", "Makandura", districtMathara));
            subDivisionRepository.save(new SubDivision("Yatiyana", "Yatiyana", districtMathara));

            District districtHambantota = districtRepository.save(new District("Hambantota", "Hambantota", provinceSouthern));
            subDivisionRepository.save(new SubDivision("Katharagama", "Katharagama", districtHambantota));
            subDivisionRepository.save(new SubDivision("Tangalle", "Tangalle", districtHambantota));

            Province provinceWestern = provinceRepository.save(new Province("WP", "Western"));
            districtRepository.save(new District("Colombo", "Colombo", provinceWestern));

            Province provinceNothern = provinceRepository.save(new Province("NP", "North"));
            districtRepository.save(new District("Jaffna", "Jaffna", provinceNothern));

        }
    }

}
