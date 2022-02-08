package lk.vaccine.service;

import lk.vaccine.dto.PatientDTO;
import lk.vaccine.dto.VaccineTokenDTO;
import lk.vaccine.entity.VaccineToken;

import java.util.List;

public interface VaccineTokenService {

    VaccineTokenDTO addToken(VaccineToken vaccineToken);

    VaccineTokenDTO updateToken(String vaccineTokenId, VaccineToken vaccineToken);

    boolean deleteToken(String vaccineTokenId);

    PatientDTO getMyVaccines(String nic);
}
