package com.hsj.memories_back.service;

import org.springframework.http.ResponseEntity;

import com.hsj.memories_back.common.dto.request.test.PostMemoryRequestDto;
import com.hsj.memories_back.common.dto.response.ResponseDto;
import com.hsj.memories_back.common.dto.response.test.GetMemoryResponseDto;

public interface TestService {
    ResponseEntity<ResponseDto> postMemory(PostMemoryRequestDto dto, String userId);
    ResponseEntity<? super GetMemoryResponseDto> getMemory(String userId);
}
