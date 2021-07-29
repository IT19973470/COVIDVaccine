package lk.vaccine.service.impl;

import lk.vaccine.repository.OfficerRepository;
import lk.vaccine.service.OfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfficerServiceImpl implements OfficerService {

    @Autowired
    private OfficerRepository officerRepository;

}
