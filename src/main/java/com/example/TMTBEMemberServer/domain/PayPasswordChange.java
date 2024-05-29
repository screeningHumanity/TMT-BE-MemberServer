package com.example.TMTBEMemberServer.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PayPasswordChange {

    private String uuid;
    private String payingPassword;

}