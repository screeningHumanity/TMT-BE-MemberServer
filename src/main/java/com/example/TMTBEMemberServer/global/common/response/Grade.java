package com.example.TMTBEMemberServer.global.common.response;

import lombok.Getter;

@Getter
public enum Grade {

    Silver(1),//실버 등급
    Gold(2), //골드 등금
    Platinum(3),//플레티넘 등급
    Diamond(4),//다이아몬드 등금
    Master(5), //마스터등금
    Challenger(6);//챌린저 등급
    private final int code;

    Grade(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}