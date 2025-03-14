package com.hsj.memories_back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hsj.memories_back.common.dto.request.auth.IdCheckRequestDto;
import com.hsj.memories_back.common.dto.request.auth.SignInRequestDto;
import com.hsj.memories_back.common.dto.request.auth.SignUpRequestDto;
import com.hsj.memories_back.common.dto.response.ResponseDto;
import com.hsj.memories_back.common.dto.response.auth.SignInResponseDto;
import com.hsj.memories_back.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/id-check")
    public ResponseEntity<ResponseDto> idCheck(
        @RequestBody @Valid IdCheckRequestDto requestBody
    ){
        ResponseEntity<ResponseDto> response = authService.idCheck(requestBody);
        return response;
    } 

    @PostMapping("/sign-up")
    ResponseEntity<ResponseDto> signUp(
        @RequestBody @Valid SignUpRequestDto requestBody
    ){
        ResponseEntity<ResponseDto> response = authService.signUp(requestBody);
        return response;
    }

    @PostMapping("/sign-in")
    public ResponseEntity<? super SignInResponseDto> signIn(
        @RequestBody @Valid SignInRequestDto requestBody
    ){ 
        ResponseEntity<? super SignInResponseDto> response = authService.signIn(requestBody);
        return response;
    }
}
