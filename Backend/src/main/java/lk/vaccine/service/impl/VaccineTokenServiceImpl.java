package lk.vaccine.service.impl;

import lk.vaccine.dto.PatientDTO;
import lk.vaccine.dto.PlaceDTO;
import lk.vaccine.dto.VaccineDTO;
import lk.vaccine.dto.VaccineTokenDTO;
import lk.vaccine.entity.SubDivisionOfficerPK;
import lk.vaccine.entity.VaccineToken;
import lk.vaccine.repository.VaccineTokenRepository;
import lk.vaccine.service.VaccineTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VaccineTokenServiceImpl implements VaccineTokenService {

    @Autowired
    private VaccineTokenRepository vaccineTokenRepository;

    @Override
    public VaccineTokenDTO addToken(VaccineToken vaccineToken) {
//        vaccineToken.getSubDivisionOfficer().setSubDivisionOfficerId(new SubDivisionOfficerPK(vaccineToken.getSubDivisionOfficer().getSubDivision().getSubDivisionId(), vaccineToken.getSubDivisionOfficer().getOfficer().getOfficerId()));
        vaccineToken = vaccineTokenRepository.save(vaccineToken);
        return new VaccineTokenDTO(vaccineToken, new VaccineDTO(vaccineToken.getVaccine()), new PlaceDTO(vaccineToken.getPlace()));
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

    @Override
    public List<VaccineTokenDTO> getMyVaccines(String nic) {
        List<VaccineToken> vaccineTokens = vaccineTokenRepository.getAllByPatientPatientId(nic);
        List<VaccineTokenDTO> vaccineTokenDTOS = new ArrayList<>();
        for (VaccineToken vaccineToken : vaccineTokens) {
            VaccineTokenDTO vaccineTokenDTO = new VaccineTokenDTO(vaccineToken);

            vaccineTokenDTO.setPatient(new PatientDTO(vaccineToken.getPatient()));
            vaccineTokenDTO.setPlace(new PlaceDTO(vaccineToken.getPlace()));
            vaccineTokenDTO.setVaccine(new VaccineDTO(vaccineToken.getVaccine()));
            vaccineTokenDTOS.add(vaccineTokenDTO);
        }

        return vaccineTokenDTOS;
    }
}
