package lk.vaccine.service.impl;

import lk.vaccine.repository.VaccineTokenRepository;
import lk.vaccine.service.VaccineTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccineTokenServiceImpl implements VaccineTokenService {

    @Autowired
    private VaccineTokenRepository vaccineTokenRepository;

}
