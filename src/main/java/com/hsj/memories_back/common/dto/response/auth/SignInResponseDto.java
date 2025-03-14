package com.hsj.memories_back.common.dto.response.auth;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.hsj.memories_back.common.dto.response.ResponseDto;
import lombok.Getter;

@Getter
public class SignInResponseDto extends ResponseDto {
    
    private String accessToken;
    private Integer expiration;

    // 생성자
    private SignInResponseDto(String accessToken) {
        this.accessToken = accessToken;
        // 9시간을 초로 계산
        this.expiration = 60 * 60 * 9;
    }

    public static ResponseEntity<SignInResponseDto> success(String accessToken){
        SignInResponseDto body = new SignInResponseDto(accessToken);
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

}
