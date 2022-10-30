package by.roman.test.controller.rest;

import by.roman.test.dto.UserDTO;
import by.roman.test.entity.User;
import by.roman.test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static by.roman.test.constans.AppConst.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserRestController {

    private final UserService userService;

    private final Logger logger = LoggerFactory.getLogger(UserRestController.class);

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> findAllUser(
    ) {
        return userService.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody @Valid UserDTO user) {
        userService.saveUser(user);
        logger.info(SAVE_USER_LOGGER_MESSAGE + user);
    }


    @GetMapping(value = "/delete/{id}")
    public void deleteUserById(@PathVariable Integer id) {
        userService.deleteUserById(id);
        logger.info(DELETE_USER_ID_LOGGER_MESSAGE + id);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        logger.info(USER_INFO_LOGGER_MESSAGE + userService.getUserById(id));
        return userService.getUserById(id);

    }

}
