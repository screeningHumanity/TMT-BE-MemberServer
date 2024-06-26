package com.example.TMTBEMemberServer.global.common.enumclass;

import com.example.TMTBEMemberServer.global.common.exception.CustomException;
import com.example.TMTBEMemberServer.global.common.response.BaseResponseCode;
import lombok.Getter;

@Getter
public enum State {

    SIGNUP("1"),//회원가입한 회원
    SIGNIN("2"), //로그인한 회원
    SIGNOUT("3"),//로그아웃한 회원
    OUT("4");//탈퇴한 회원

    private final String code;

    State(String code) {
        this.code = code;
    }
}
