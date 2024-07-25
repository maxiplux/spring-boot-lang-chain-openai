package app.quantun.langchanin.controllers;

import app.quantun.langchanin.services.ChatServices;


import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChatController {


    private ChatServices universityServices;

    @GetMapping("/chat")
    public String model(@RequestParam(value = "message", defaultValue = "How many customers do we have?") String message) {
        return this.universityServices.getAnswer(message);


    }

}
