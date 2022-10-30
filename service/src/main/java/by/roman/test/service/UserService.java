package by.roman.test.service;

import by.roman.test.dto.UserDTO;
import by.roman.test.entity.User;

import java.util.List;


public interface UserService {
    List<UserDTO> findAll();

    void saveUser(UserDTO user);

    void deleteUserById(Integer id);

    User getUserById(Integer id);
}
