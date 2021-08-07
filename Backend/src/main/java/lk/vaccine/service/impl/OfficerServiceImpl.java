package lk.vaccine.service.impl;

import lk.vaccine.dto.OfficerDTO;
import lk.vaccine.dto.SubDivisionOfficerDTO;
import lk.vaccine.dto.VaccineUserDTO;
import lk.vaccine.entity.Officer;
import lk.vaccine.entity.SubDivisionOfficer;
import lk.vaccine.entity.SubDivisionOfficerPK;
import lk.vaccine.entity.VaccineUser;
import lk.vaccine.repository.OfficerRepository;
import lk.vaccine.repository.VaccineUserRepository;
import lk.vaccine.service.OfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfficerServiceImpl implements OfficerService {

    @Autowired
    private OfficerRepository officerRepository;
    @Autowired
    private VaccineUserRepository vaccineUserRepository;

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

    @Override
    public VaccineUserDTO login(VaccineUser vaccineUser) {
        VaccineUser usernameAndPassword = vaccineUserRepository.getAllByUsernameAndPassword(vaccineUser.getUsername(), vaccineUser.getPassword());
        if (usernameAndPassword != null) {
            return new VaccineUserDTO(usernameAndPassword);
        }
        return null;
    }
}
