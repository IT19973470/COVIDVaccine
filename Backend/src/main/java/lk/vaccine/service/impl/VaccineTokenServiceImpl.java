package lk.vaccine.service.impl;

import lk.vaccine.dto.VaccineTokenDTO;
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
        return null;
    }

    @Override
    public VaccineTokenDTO updateToken(String vaccineTokenId, VaccineToken vaccineToken) {
        return null;
    }

    @Override
    public VaccineTokenDTO deleteToken(String vaccineTokenId) {
        return null;
    }
}
