package lk.vaccine.service;

import lk.vaccine.dto.VaccineTokenDTO;
import lk.vaccine.entity.VaccineToken;

import java.util.List;

public interface VaccineTokenService {

    VaccineTokenDTO addToken(VaccineToken vaccineToken);

    VaccineTokenDTO updateToken(String vaccineTokenId, VaccineToken vaccineToken);

    boolean deleteToken(String vaccineTokenId);

    List<VaccineTokenDTO> getMyVaccines(String nic);
}
