package kr.jojoba.user.domain.dto;

import kr.jojoba.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    private String id;
    private String email;

    public static UserResponseDto of(User user) {
        return UserResponseDto.builder()
                              .id(String.valueOf(user.getId()))
                              .email(user.getEmail())
                              .build();
    }
}
