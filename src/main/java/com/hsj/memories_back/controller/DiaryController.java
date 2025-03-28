package com.hsj.memories_back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hsj.memories_back.common.dto.request.diary.PatchDiaryRequestDto;
import com.hsj.memories_back.common.dto.request.diary.PostCommentRequestDto;
import com.hsj.memories_back.common.dto.request.diary.PostDiaryRequestDto;
import com.hsj.memories_back.common.dto.response.ResponseDto;
import com.hsj.memories_back.common.dto.response.diary.GetCommentReponseDto;
import com.hsj.memories_back.common.dto.response.diary.GetDiaryResponseDto;
import com.hsj.memories_back.common.dto.response.diary.GetEmpathyResponseDto;
import com.hsj.memories_back.common.dto.response.diary.GetMyDiaryResponseDto;
import com.hsj.memories_back.service.DiarySerivce;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/v1/diary")
@RequiredArgsConstructor
public class DiaryController {
    
    private final DiarySerivce diarySerive;

    // 주소 입력시 주소의 마지막 /의 유무의 차이가 없게 설정
    @PostMapping({"", "/"})
    public ResponseEntity<ResponseDto> postDiary(
        @RequestBody @Valid PostDiaryRequestDto requestBody,
        @AuthenticationPrincipal String userId
    ) { 
        ResponseEntity<ResponseDto> response = diarySerive.postDiary(requestBody, userId);
        return  response;
    }

    @GetMapping("/my")
    public ResponseEntity<? super GetMyDiaryResponseDto> getMyDiary( 
        @AuthenticationPrincipal String userId
    ){ 
        ResponseEntity<? super GetMyDiaryResponseDto> response = diarySerive.getMyDiary(userId);
        return response;
    } 

    @GetMapping("/{diaryNumber}")
    public ResponseEntity<? super GetDiaryResponseDto> getDiary( 
        @PathVariable("diaryNumber") Integer diaryNumber
    ){ 
        ResponseEntity<? super GetDiaryResponseDto> response = diarySerive.getDiary(diaryNumber);
        return response;
    }
    
    @PatchMapping("/{diaryNumber}")
    public ResponseEntity<ResponseDto> patchDiary(
        @RequestBody @Valid PatchDiaryRequestDto requestBody,
        @PathVariable("diaryNumber") Integer diaryNumber,
        @AuthenticationPrincipal String userId
    ) { 
        ResponseEntity<ResponseDto> response = diarySerive.patchDiary(requestBody, diaryNumber, userId);
        return response;
    }

    @DeleteMapping("/{diaryNumber}")
    public ResponseEntity<ResponseDto> deleteDiary( 
        @PathVariable("diaryNumber") Integer diaryNumber,
        @AuthenticationPrincipal String userId
    ){ 
        ResponseEntity<ResponseDto> response = diarySerive.deleteDiary(diaryNumber, userId);
        return response;
    }

    @GetMapping("/{diaryNumber}/empathy")
    public ResponseEntity<? super GetEmpathyResponseDto> getEmpathy( 
      @PathVariable("diaryNumber") Integer diaryNumber
    ){
        ResponseEntity<? super GetEmpathyResponseDto> response = diarySerive.getEmpathy(diaryNumber);
        return response;
    }
    

    @PutMapping("/{diaryNumber}/empathy")
    public ResponseEntity<ResponseDto> putEmpathy(
      @PathVariable("diaryNumber") Integer diaryNumber,
      @AuthenticationPrincipal String userId
    ) { 
      ResponseEntity<ResponseDto> response = diarySerive.putEmpathy(diaryNumber, userId);
      return response;
    }

    @GetMapping("/{diaryNumber}/comment")
    public ResponseEntity<? super GetCommentReponseDto> getComment( 
      @PathVariable("diaryNumber") Integer diaryNumber
    ){ 
        ResponseEntity<? super GetCommentReponseDto> response =  diarySerive.getComment(diaryNumber);
        return response;
    }
    

    @PostMapping("/{diaryNumber}/comment")
    public ResponseEntity<ResponseDto> postComment( 
      @RequestBody @Valid PostCommentRequestDto requestBody,
      @PathVariable("diaryNumber") Integer diaryNumber,
      @AuthenticationPrincipal String userId
    ){  
      ResponseEntity<ResponseDto> response = diarySerive.postComment(requestBody, diaryNumber, userId);
      return response;
    }
}
