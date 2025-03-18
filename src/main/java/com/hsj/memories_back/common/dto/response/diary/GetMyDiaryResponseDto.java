package com.hsj.memories_back.common.dto.response.diary;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hsj.memories_back.common.dto.response.ResponseDto;
import com.hsj.memories_back.common.entity.DiaryEntity;
import com.hsj.memories_back.common.vo.DiaryVO;

import lombok.Getter;

@Getter
public class GetMyDiaryResponseDto extends ResponseDto{
    
    private List<DiaryVO> diaries;

    // 생성자 만들기
    private GetMyDiaryResponseDto(List<DiaryEntity> diaryEntities) { 
        this.diaries = DiaryVO.getList(diaryEntities);
    }

    public static ResponseEntity<GetMyDiaryResponseDto> success(List<DiaryEntity> diaryEntities) { 
        GetMyDiaryResponseDto body = new GetMyDiaryResponseDto(diaryEntities);
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }
}
