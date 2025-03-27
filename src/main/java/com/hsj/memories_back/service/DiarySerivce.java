package com.hsj.memories_back.service;

import org.springframework.http.ResponseEntity;

import com.hsj.memories_back.common.dto.request.diary.PatchDiaryRequestDto;
import com.hsj.memories_back.common.dto.request.diary.PostCommentRequestDto;
import com.hsj.memories_back.common.dto.request.diary.PostDiaryRequestDto;
import com.hsj.memories_back.common.dto.response.ResponseDto;
import com.hsj.memories_back.common.dto.response.diary.GetDiaryResponseDto;
import com.hsj.memories_back.common.dto.response.diary.GetEmpathyResponseDto;
import com.hsj.memories_back.common.dto.response.diary.GetMyDiaryResponseDto;

public interface DiarySerivce {
    ResponseEntity<ResponseDto> postDiary(PostDiaryRequestDto dto, String userId);
    ResponseEntity<? super GetMyDiaryResponseDto> getMyDiary(String userId);
    ResponseEntity<? super GetDiaryResponseDto> getDiary(Integer diaryNumber);
    ResponseEntity<ResponseDto> patchDiary(PatchDiaryRequestDto dto, Integer diaryNumber, String userId);
    ResponseEntity<ResponseDto> deleteDiary(Integer diaryNumber, String userId);

    ResponseEntity<? super GetEmpathyResponseDto> getEmpathy(Integer diaryNumber);
    // 몇번일기에, 누가 작업을 하는지..
    ResponseEntity<ResponseDto> putEmpathy(Integer diaryNumber, String userId);

    ResponseEntity<ResponseDto> postComment(PostCommentRequestDto dto, Integer diaryNumber, String userId);
} 
