package com.hsj.memories_back.common.dto.response.test;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hsj.memories_back.common.dto.response.ResponseDto;
import com.hsj.memories_back.common.entity.ConcentrationTestEntity;
import com.hsj.memories_back.common.vo.ConcentrationTestVO;

import lombok.Getter;

@Getter
public class GetRecentlyConcentrationResponseDto extends ResponseDto{
  private List<ConcentrationTestVO> concentrationTests;

  // 생성자
  private GetRecentlyConcentrationResponseDto( 
    List<ConcentrationTestEntity> concentrationTestEntities
  ){ 
    this.concentrationTests = ConcentrationTestVO.getList(concentrationTestEntities);
  }
  public static ResponseEntity<GetRecentlyConcentrationResponseDto> success( 
    List<ConcentrationTestEntity> concentrationTestEntities
  ){ 
    GetRecentlyConcentrationResponseDto body = new
    GetRecentlyConcentrationResponseDto(concentrationTestEntities);
    return ResponseEntity.status(HttpStatus.OK).body(body);
  }
}
