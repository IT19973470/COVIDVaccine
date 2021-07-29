package lk.vaccine.service;

import lk.vaccine.dto.VaccineTokenDTO;
import lk.vaccine.entity.VaccineToken;

public interface VaccineTokenService {

    VaccineTokenDTO addToken(VaccineToken vaccineToken);

    VaccineTokenDTO updateToken(String vaccineTokenId, VaccineToken vaccineToken);

    VaccineTokenDTO deleteToken(String vaccineTokenId);
}
