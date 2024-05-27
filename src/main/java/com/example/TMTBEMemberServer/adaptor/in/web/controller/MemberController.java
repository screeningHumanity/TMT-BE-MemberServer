package com.example.TMTBEMemberServer.adaptor.in.web.controller;

import com.example.TMTBEMemberServer.adaptor.in.web.vo.NicknameChangeRequestVo;
import com.example.TMTBEMemberServer.adaptor.in.web.vo.PayPasswordRequestVo;
import com.example.TMTBEMemberServer.adaptor.in.web.vo.PaypasswordChangeRequestVo;
import com.example.TMTBEMemberServer.adaptor.in.web.vo.SignInRequestVo;
import com.example.TMTBEMemberServer.adaptor.in.web.vo.SignUpRequestVo;
import com.example.TMTBEMemberServer.application.port.in.usecase.NickNameChangeUsecase;
import com.example.TMTBEMemberServer.application.port.out.dto.SignInResponseDto;
import com.example.TMTBEMemberServer.application.port.in.usecase.PayPasswordUsecase;
import com.example.TMTBEMemberServer.application.port.in.usecase.RandomNicknameUsecase;
import com.example.TMTBEMemberServer.application.port.in.usecase.SignInUsecase;
import com.example.TMTBEMemberServer.application.port.in.usecase.SignUpUsecase;
import com.example.TMTBEMemberServer.application.port.out.dto.RandomNicknameDto;
import com.example.TMTBEMemberServer.global.common.response.BaseResponse;
import com.example.TMTBEMemberServer.global.common.token.DecodingToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Slf4j
@Validated
public class MemberController {

    private final ModelMapper modelMapper;
    private final SignUpUsecase signUpUsecase;
    private final RandomNicknameUsecase randomNicknameUsecase;
    private final PayPasswordUsecase payPasswordUsecase;
    private final SignInUsecase signInUsecase;
    private final DecodingToken decodingToken;
    private final NickNameChangeUsecase nickNameChangeUsecase;

    @PostMapping("/signup") //회원가입
    public BaseResponse<Void> SignUp(@RequestBody SignUpRequestVo signUpRequestVo) {

        signUpUsecase.SignUp(modelMapper.map(signUpRequestVo, SignUpUsecase.SignUpRequiredDto.class));
        return new BaseResponse<>();

    }

    @GetMapping("/random-nickname") //랜덤 닉네임생성
    public BaseResponse<String> randomNickName() {

        RandomNicknameDto randomNicknameDto = randomNicknameUsecase.createRamdomNickName();
        String result = randomNicknameDto.getNickname();
        return new BaseResponse<>(result);


    }

    @PostMapping("/pay-password")//결제 비밀번호 설정
    public BaseResponse<Void> payPassword(@RequestBody PayPasswordRequestVo payPasswordRequestVo) {
        payPasswordUsecase.payPasswordUpdate(modelMapper.map(payPasswordRequestVo,
                PayPasswordUsecase.payPasswordRequestDto.class));
        return new BaseResponse<>();

    }

    @PostMapping("/signin")
    public BaseResponse<SignInResponseDto> signin(@RequestBody SignInRequestVo signInRequestVo) {

        SignInResponseDto SigninResponseDto = signInUsecase.SigninService(modelMapper.map(signInRequestVo,
                SignInUsecase.SigninRequestDto.class));
        return new BaseResponse<>(SigninResponseDto);

    }

    @PostMapping("/nickname") //닉네임 변경
    public BaseResponse<Void> nicknameChange(@RequestHeader ("Authorization") String jwt,
            @RequestBody NicknameChangeRequestVo
            nicknameChangeRequestVo) {

        String uuid = decodingToken.getUuid(jwt);

        nickNameChangeUsecase.nicknameChange(modelMapper.map(nicknameChangeRequestVo,
                NickNameChangeUsecase.nicknameChangeRequestDto.class),uuid);

        return new BaseResponse<>();
    }

    @PostMapping("/pay-password")
    public BaseResponse<Void> payPasswordChange(@RequestHeader ("Authorization") String jwt,
            @RequestBody PaypasswordChangeRequestVo paypasswordChangeRequestVo) {

        String uuid = decodingToken.getUuid(jwt);

        return new BaseResponse<>();

    }

}
