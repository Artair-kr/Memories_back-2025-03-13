package com.hsj.memories_back.common.dto.response.openai;

import java.util.List;

import com.hsj.memories_back.common.vo.GptChoiceVO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatResponseDto {
  // 질문의 대답이 여러개일 수 있다.
  private List<GptChoiceVO> choices;
}
