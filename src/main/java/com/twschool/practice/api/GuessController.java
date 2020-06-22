package com.twschool.practice.api;

import com.twschool.practice.domain.AnswerGenerator;
import com.twschool.practice.domain.GuessNumberGame;
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
        GameService gameService = new GameService(new GuessNumberGame(new AnswerGenerator()));
        Map<String, String> responseBody = new HashMap<>();
        String number = requestBody.get("number");
        String result = gameService.guess(requestBody.get("number"));

        responseBody.put("input", number);
        responseBody.put("result", result);

        return responseBody;
    }

}
