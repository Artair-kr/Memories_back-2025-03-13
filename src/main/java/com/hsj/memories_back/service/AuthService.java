package com.hsj.memories_back.service;

import org.springframework.http.ResponseEntity;

import com.hsj.memories_back.common.dto.request.auth.IdCheckRequestDto;
import com.hsj.memories_back.common.dto.request.auth.SignInRequestDto;
import com.hsj.memories_back.common.dto.request.auth.SignUpRequestDto;
import com.hsj.memories_back.common.dto.response.ResponseDto;
import com.hsj.memories_back.common.dto.response.auth.SignInResponseDto;

public interface AuthService {
    ResponseEntity<ResponseDto> idCheck(IdCheckRequestDto dto);
    ResponseEntity<ResponseDto> signUp(SignUpRequestDto dto);
    //! 와일드 카드형태로 입력
    // super : 본인과 부모타입 사용
    // extends : 본인과 자식타입 사용
    ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);
}

