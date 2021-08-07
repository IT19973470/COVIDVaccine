package lk.vaccine.service;

import lk.vaccine.dto.OfficerDTO;
import lk.vaccine.dto.SubDivisionOfficerDTO;
import lk.vaccine.dto.VaccineUserDTO;
import lk.vaccine.entity.Officer;
import lk.vaccine.entity.SubDivisionOfficer;
import lk.vaccine.entity.SubDivisionOfficerPK;
import lk.vaccine.entity.VaccineUser;

public interface OfficerService {

    OfficerDTO addOfficer(Officer officer);

    OfficerDTO updateOfficer(String officerId, Officer officer);

    OfficerDTO deleteOfficer(String officerId);

    SubDivisionOfficerDTO addSubDivisionOfficer(SubDivisionOfficer subDivisionOfficer);

    SubDivisionOfficerDTO updateSubDivisionOfficer(SubDivisionOfficerPK subDivisionOfficerPK, SubDivisionOfficer subDivisionOfficer);

    SubDivisionOfficerDTO deleteSubDivisionOfficer(SubDivisionOfficerPK subDivisionOfficerPK);

    VaccineUserDTO login(VaccineUser vaccineUser);
}
