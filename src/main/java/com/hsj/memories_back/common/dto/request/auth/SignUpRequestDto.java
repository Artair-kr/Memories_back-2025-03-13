package com.hsj.memories_back.common.dto.request.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequestDto {

    @NotBlank
    // 띄어쓰기 불가
    @Pattern(regexp="^[a-zA-Z0-9]{6,20}$")
    private String userId;

    @NotBlank
    // 영문과 숫자가 반드시 포함되어야 한다.
    @Pattern(regexp="^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{8,13}$")
    private String userPassword;

    @NotBlank
    // 한글로만 이루어져야한다.
    @Pattern(regexp="^[가-힣]{2,5}$")
    private String name;

    @NotBlank
    private String address;

    private String detailAddress;

    @NotBlank
    @Pattern(regexp="^(NORMAL|KAKAO|NAVER)$")
    private String joinType;
}
