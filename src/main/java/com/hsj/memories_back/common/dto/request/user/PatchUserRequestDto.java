package com.hsj.memories_back.common.dto.request.user;

import jakarta.validation.constraints.Min;
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
public class PatchUserRequestDto {

    @NotBlank
    // 한글로만 이루어져야한다.
    @Pattern(regexp="^[가-힣]{2,5}$")
    private String name;

    private String profileImage;

    @NotBlank
    private String address;

    private String detailAddress;

    // 필수는 아니지만 남성(man), 여성(woman)만 존재한다. //
    @Pattern(regexp="^(man|woman)$")
    private String gender;

    // 최소 0보다 크거나 같다는 제약 //
    @Min(0)
    private Integer age;
}
