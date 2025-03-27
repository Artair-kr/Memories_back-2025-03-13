package com.hsj.memories_back.common.vo;

import java.util.ArrayList;
import java.util.List;

import com.hsj.memories_back.common.entity.CommentEntity;

import lombok.Getter;

@Getter
public class CommentVO {
  private Integer commentNumber;
  private String commentWriterId;
  private String commentwriteDate;
  private String comment;

  private CommentVO(CommentEntity commentEntity){ 
    this.commentNumber = commentEntity.getCommentNumber();
    this.commentWriterId = commentEntity.getUserId();
    this.commentwriteDate = commentEntity.getWriteDate();
    this.comment = commentEntity.getContent();
  }

  public static List<CommentVO> getList(List<CommentEntity> commentEntities) { 
    List<CommentVO> list = new ArrayList<>();
    for(CommentEntity commentEntity: commentEntities){
      CommentVO vo = new CommentVO(commentEntity);
      list.add(vo);
    }
    return list;
  }
}
