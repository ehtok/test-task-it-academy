package by.roman.test.service.implement;

import by.roman.test.converter.Converter;
import by.roman.test.converter.implement.UserConverter;
import by.roman.test.dto.UserDTO;
import by.roman.test.entity.User;
import by.roman.test.exception.NotFoundException;
import by.roman.test.repository.UserRepository;
import by.roman.test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static by.roman.test.constans.AppConst.NOT_FOUND_MESSAGE;
import static by.roman.test.constans.AppConst.USER_WITH_ID_MESSAGE;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final Converter<User, UserDTO> converter = new UserConverter();


    @Override
    public List<UserDTO> findAll() {
        return converter.toListDTO(userRepository.findAll());
    }

    @Override
    public void saveUser(UserDTO user) {

        userRepository.save(converter.toEntity(user));
    }

    @Override
    public void deleteUserById(Integer id) {
        userRepository.deleteById(Optional.ofNullable(id).orElseThrow(() -> new NotFoundException(USER_WITH_ID_MESSAGE + id + NOT_FOUND_MESSAGE)));

    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException(USER_WITH_ID_MESSAGE + id + NOT_FOUND_MESSAGE));
    }


}
