package com.example.TMTBEMemberServer.application.port.in.usecase;

import com.example.TMTBEMemberServer.application.port.out.dto.ReAccessTokenDto;

public interface TokenUsecase {

    ReAccessTokenDto reissueToken(String jwt);
}
