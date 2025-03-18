package com.hsj.memories_back.service;

import org.springframework.http.ResponseEntity;

import com.hsj.memories_back.common.dto.request.diary.PostDiaryRequestDto;
import com.hsj.memories_back.common.dto.response.ResponseDto;
import com.hsj.memories_back.common.dto.response.diary.GetMyDiaryResponseDto;

public interface DiarySerivce {
    ResponseEntity<ResponseDto> postDiary(PostDiaryRequestDto dto, String userId);
    ResponseEntity<? super GetMyDiaryResponseDto> getMyDiary(String userId);
} 
