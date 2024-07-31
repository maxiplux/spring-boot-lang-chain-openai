package app.quantun.langchanin.controllers;

import app.quantun.langchanin.models.dto.Answer;
import app.quantun.langchanin.services.ChatServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class ChatController {


    private  final ChatServices universityServices;

    @PostMapping("/questions/")
    public Answer model(@RequestBody  String message ) {
        //    public String model(@RequestParam(value = "message", defaultValue = "How many customers do we have?") String message) {
        return this.universityServices.getAnswer(message);


    }

}
