package net.Duncie.Test.dto.service;

import net.Duncie.Test.dto.UserDto;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    RuntimeService runtimeService;

    public void startProcessByMessage(UserDto userDto) throws Exception {
        String email = userDto.getEmail();
        String gender = userDto.getGender();
        runtimeService.createMessageCorrelation("create")
                .setVariable("email", email)
                .setVariable("gender", gender)
                .correlateWithResult();
    }
}
