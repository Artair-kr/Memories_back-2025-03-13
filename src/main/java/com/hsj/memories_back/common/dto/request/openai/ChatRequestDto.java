package com.hsj.memories_back.common.dto.request.openai;

import java.util.List;

import com.hsj.memories_back.common.vo.GptMessageVo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatRequestDto {
  private String model;
  // list 안에는 role과 content
  private List<GptMessageVo> messages;
}

