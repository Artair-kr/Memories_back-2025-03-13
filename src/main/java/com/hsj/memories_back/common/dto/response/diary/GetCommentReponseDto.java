package com.hsj.memories_back.common.dto.response.diary;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hsj.memories_back.common.dto.response.ResponseDto;
import com.hsj.memories_back.common.entity.CommentEntity;
import com.hsj.memories_back.common.vo.CommentVO;

import lombok.Getter;

@Getter
public class GetCommentReponseDto extends ResponseDto {
  private List<CommentVO> comments;

  private GetCommentReponseDto(List<CommentEntity> commentEntities) { 
    this.comments = CommentVO.getList(commentEntities);
  }

  public static ResponseEntity<GetCommentReponseDto> success(List<CommentEntity> commentEntities){
    GetCommentReponseDto body = new GetCommentReponseDto(commentEntities);
    return ResponseEntity.status(HttpStatus.OK).body(body);
  }
}
