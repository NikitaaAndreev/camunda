package net.Duncie.Test.dto.controller;

import net.Duncie.Test.dto.UserDto;
import net.Duncie.Test.dto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("getInfo")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public UserDto getParams(@RequestBody UserDto userDto) {
        try {
            userService.startProcessByMessage(userDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return userDto;
    }
}
