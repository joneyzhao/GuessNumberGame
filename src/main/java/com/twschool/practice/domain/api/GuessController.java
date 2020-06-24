package com.twschool.practice.domain.api;

import com.twschool.practice.domain.User;
import com.twschool.practice.domain.service.GameService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GuessController {

    @PostMapping("/games/guess-number")
    public Map<String,String> guess(@RequestBody Map<String, String> requestBody){
        Map<String, String> responseBody = new HashMap<>();
        String number = requestBody.get("number");
        String userId = requestBody.get("userId");

        User user = new User(userId);
        String result = user.getResultString(number);

        responseBody.put("input", number);
        responseBody.put("result", result);

        return responseBody;
    }

}
