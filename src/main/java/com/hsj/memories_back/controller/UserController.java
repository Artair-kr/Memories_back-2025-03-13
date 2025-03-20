package com.hsj.memories_back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hsj.memories_back.common.dto.request.user.PatchUserRequestDto;
import com.hsj.memories_back.common.dto.response.ResponseDto;
import com.hsj.memories_back.common.dto.response.user.GetSignInUserResponseDto;
import com.hsj.memories_back.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/sign-in")
    public ResponseEntity<? super GetSignInUserResponseDto> getSignInUse
    (
      @AuthenticationPrincipal String userId
    ){ 
      ResponseEntity<? super GetSignInUserResponseDto> response = 
      userService.getSignInUser(userId);
      return response;
    }

    @PatchMapping({"","/"})
    public ResponseEntity<ResponseDto> patchUser( 
      @RequestBody @Valid PatchUserRequestDto requestBody, 
      @AuthenticationPrincipal String userId
    ){ 
      ResponseEntity<ResponseDto> responses = userService.patchUser(requestBody, userId);
      return responses;
    }
}
