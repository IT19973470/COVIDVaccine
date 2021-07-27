package lk.vaccine.util;

import lk.vaccine.entity.District;
import lk.vaccine.entity.Province;
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

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        if (provinceRepository.findAll().size() == 0 && districtRepository.findAll().size() == 0) {

            Province province1 = new Province("P1", "Southern");
            provinceRepository.save(province1);
            districtRepository.save(new District("D1", "Galle", province1));
            districtRepository.save(new District("D3", "Mathara", province1));
            districtRepository.save(new District("D4", "Hambantota", province1));

            Province province2 = new Province("P1", "Western");
            provinceRepository.save(province2);
            districtRepository.save(new District("D2", "Colombo", province2));

            Province province3 = new Province("P1", "Nothern");
            provinceRepository.save(province3);
            districtRepository.save(new District("D5", "Jaffna", province3));

        }
    }

}
