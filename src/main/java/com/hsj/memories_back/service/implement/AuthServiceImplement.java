package com.hsj.memories_back.service.implement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hsj.memories_back.common.dto.request.auth.IdCheckRequestDto;
import com.hsj.memories_back.common.dto.response.ResponseDto;
import com.hsj.memories_back.service.AuthService;

@Service
public class AuthServiceImplement implements AuthService{

    @Override
    public ResponseEntity<ResponseDto> idCheck(IdCheckRequestDto dto) {

        return ResponseDto.success(HttpStatus.OK);
    } 
}
