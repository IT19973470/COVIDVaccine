package lk.vaccine.service.impl;

import lk.vaccine.dto.OfficerDTO;
import lk.vaccine.dto.SubDivisionOfficerDTO;
import lk.vaccine.entity.Officer;
import lk.vaccine.entity.SubDivisionOfficer;
import lk.vaccine.entity.SubDivisionOfficerPK;
import lk.vaccine.repository.OfficerRepository;
import lk.vaccine.service.OfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfficerServiceImpl implements OfficerService {

    @Autowired
    private OfficerRepository officerRepository;

    @Override
    public OfficerDTO addOfficer(Officer officer) {
        return null;
    }

    @Override
    public OfficerDTO updateOfficer(String officerId, Officer officer) {
        return null;
    }

    @Override
    public OfficerDTO deleteOfficer(String officerId) {
        return null;
    }

    @Override
    public SubDivisionOfficerDTO addSubDivisionOfficer(SubDivisionOfficer subDivisionOfficer) {
        return null;
    }

    @Override
    public SubDivisionOfficerDTO updateSubDivisionOfficer(SubDivisionOfficerPK subDivisionOfficerPK, SubDivisionOfficer subDivisionOfficer) {
        return null;
    }

    @Override
    public SubDivisionOfficerDTO deleteSubDivisionOfficer(SubDivisionOfficerPK subDivisionOfficerPK) {
        return null;
    }
}
