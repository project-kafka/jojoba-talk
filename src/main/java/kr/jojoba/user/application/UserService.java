package kr.jojoba.user.application;

import java.util.UUID;
import kr.jojoba.errors.NotFoundException;
import kr.jojoba.user.domain.User;
import kr.jojoba.user.domain.dto.UserCreateRequestDto;
import kr.jojoba.user.domain.dto.UserResponseDto;
import kr.jojoba.user.infrastructure.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDto createUser(UserCreateRequestDto requestDto) {
        final User user = User.builder()
                              .email(requestDto.getEmail())
                              .password(requestDto.getPassword())
                              .build();
        userRepository.save(user);
        return UserResponseDto.of(user);
    }

    public UserResponseDto getUserById(String id) {
        final User user = userRepository.findById(UUID.fromString(id))
                                        .orElseThrow(() -> new NotFoundException(
                                            String.format("Cannot found user entity [id = %s]", id)
                                        ));
        return UserResponseDto.of(user);
    }
}
