package by.roman.test.converter.implement;

import by.roman.test.converter.Converter;
import by.roman.test.dto.UserDTO;
import by.roman.test.entity.User;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UserConverter implements Converter<User, UserDTO> {
    @Override
    public UserDTO toDTO(User entity) {
        return UserDTO.builder()
                .surName(entity.getSurName())
                .name(entity.getName())
                .middleName(entity.getMiddleName())
                .email(entity.getEmail())
                .role(entity.getRole())
                .build();
    }

    @Override
    public List<UserDTO> toListDTO(List<User> entity) {

        return entity.stream()
                .map(this::toDTO)
                .sorted(Comparator.comparing(UserDTO::getEmail))
                .collect(Collectors.toList());
    }

    @Override
    public User toEntity(UserDTO dto) {
        return User.builder()
                .surName(dto.getSurName())
                .name(dto.getName())
                .middleName(dto.getMiddleName())
                .email(dto.getEmail())
                .role(dto.getRole())
                .build();
    }
}
