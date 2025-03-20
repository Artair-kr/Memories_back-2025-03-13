package com.hsj.memories_back.service;

import org.springframework.http.ResponseEntity;

import com.hsj.memories_back.common.dto.request.user.PatchUserRequestDto;
import com.hsj.memories_back.common.dto.response.ResponseDto;
import com.hsj.memories_back.common.dto.response.user.GetSignInUserResponseDto;

public interface UserService {
    ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String userId);
    // 로그인하고 있는 사용자 String userId를 받아온다.
    ResponseEntity<ResponseDto> patchUser(PatchUserRequestDto dto, String userId);
}
