package lk.vaccine.service.impl;

import lk.vaccine.dto.OfficerDTO;
import lk.vaccine.dto.SubDivisionOfficerDTO;
import lk.vaccine.dto.VaccineUserDTO;
import lk.vaccine.entity.Officer;
import lk.vaccine.entity.SubDivisionOfficer;
import lk.vaccine.entity.SubDivisionOfficerPK;
import lk.vaccine.entity.VaccineUser;
import lk.vaccine.repository.OfficerRepository;
import lk.vaccine.repository.SubDivisionOfficerRepository;
import lk.vaccine.repository.VaccineUserRepository;
import lk.vaccine.service.OfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class OfficerServiceImpl implements OfficerService {

    @Autowired
    private OfficerRepository officerRepository;
    @Autowired
    private VaccineUserRepository vaccineUserRepository;
    @Autowired
    private SubDivisionOfficerRepository subDivisionOfficerRepository;

    @Override
    public OfficerDTO addOfficer(Officer officer) {
        VaccineUser vaccineUser = new VaccineUser();
        vaccineUser.setType("officer");
        vaccineUser.setUserNic(officer.getOfficerId());
        vaccineUser.setUsername(officer.getFirstName());
        vaccineUser.setPassword((new Random().nextInt(10000) + 1) + "");
        vaccineUserRepository.save(vaccineUser);
        return new OfficerDTO(officerRepository.save(officer));
    }

    @Override
    public OfficerDTO updateOfficer(String officerId, Officer officer) {
        Optional<Officer> optionalOfficer = officerRepository.findById(officerId);
        if (optionalOfficer.isPresent()) {
            Officer officerObj = optionalOfficer.get();
            officerObj.setFirstName(officer.getFirstName());
            officerObj.setLastName(officer.getLastName());
            return new OfficerDTO(officerRepository.save(officerObj));
        }
        return null;
    }

    @Override
    public boolean deleteOfficer(String officerId) {
        officerRepository.deleteById(officerId);
        return true;
    }

    @Override
    public SubDivisionOfficerDTO addSubDivisionOfficer(SubDivisionOfficer subDivisionOfficer) {
        subDivisionOfficer.setSubDivisionOfficerId(new SubDivisionOfficerPK(subDivisionOfficer.getSubDivision().getSubDivisionId(), subDivisionOfficer.getOfficer().getOfficerId()));
        subDivisionOfficer = subDivisionOfficerRepository.save(subDivisionOfficer);
        return new SubDivisionOfficerDTO(subDivisionOfficer, new OfficerDTO(subDivisionOfficer.getOfficer()));
    }

    @Override
    public SubDivisionOfficerDTO updateSubDivisionOfficer(SubDivisionOfficerPK subDivisionOfficerPK, SubDivisionOfficer subDivisionOfficer) {
        return null;
    }

    @Override
    public boolean deleteSubDivisionOfficer(SubDivisionOfficerPK subDivisionOfficerPK) {
        subDivisionOfficerRepository.deleteById(subDivisionOfficerPK);
        return true;
    }

    @Override
    public VaccineUserDTO login(VaccineUser vaccineUser) {
        VaccineUser usernameAndPassword = vaccineUserRepository.getAllByUsernameAndPassword(vaccineUser.getUsername(), vaccineUser.getPassword());
        if (usernameAndPassword != null) {
            return new VaccineUserDTO(usernameAndPassword);
        }
        return null;
    }

    @Override
    public List<OfficerDTO> getSubDivisionOfficers() {
        List<Officer> officerList = officerRepository.findAll();
        List<OfficerDTO> officerDTOS = new ArrayList<>();
        for (Officer officer : officerList) {
            officerDTOS.add(new OfficerDTO(officer));
        }
        return officerDTOS;
    }

    @Override
    public List<OfficerDTO> getOfficersForSubDivision(String subDivisionId) {
        List<SubDivisionOfficer> subDivisionOfficers = subDivisionOfficerRepository.findAllBySubDivisionSubDivisionId(subDivisionId);
        List<OfficerDTO> officerDTOS = new ArrayList<>();
        for (SubDivisionOfficer subDivisionOfficer : subDivisionOfficers) {
            officerDTOS.add(new OfficerDTO(subDivisionOfficer.getOfficer()));
        }
        return officerDTOS;
    }
}
