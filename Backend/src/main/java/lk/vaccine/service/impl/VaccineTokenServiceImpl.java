package lk.vaccine.service.impl;

import lk.vaccine.dto.VaccineTokenDTO;
import lk.vaccine.entity.SubDivisionOfficerPK;
import lk.vaccine.entity.VaccineToken;
import lk.vaccine.repository.VaccineTokenRepository;
import lk.vaccine.service.VaccineTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccineTokenServiceImpl implements VaccineTokenService {

    @Autowired
    private VaccineTokenRepository vaccineTokenRepository;

    @Override
    public VaccineTokenDTO addToken(VaccineToken vaccineToken) {
//        vaccineToken.getSubDivisionOfficer().setSubDivisionOfficerId(new SubDivisionOfficerPK(vaccineToken.getSubDivisionOfficer().getSubDivision().getSubDivisionId(), vaccineToken.getSubDivisionOfficer().getOfficer().getOfficerId()));
        return new VaccineTokenDTO(vaccineTokenRepository.save(vaccineToken));
    }

    @Override
    public VaccineTokenDTO updateToken(String vaccineTokenId, VaccineToken vaccineToken) {
        return null;
    }

    @Override
    public boolean deleteToken(String vaccineTokenId) {
        vaccineTokenRepository.deleteById(vaccineTokenId);
        return true;
    }
}
