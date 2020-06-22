package com.twschool.practice.api;

import com.twschool.practice.domain.service.GameService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GuessController {
    private GameService gameService;

    public GuessController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/games/guess-number")
    public Map<String,String> guess(@RequestBody Map<String, String> requestBody){
        Map<String, String> responseBody = new HashMap<>();
        String number = requestBody.get("number");
        String result = gameService.guess(number);

        responseBody.put("input", number);
        responseBody.put("result", result);

        return responseBody;
    }

}
