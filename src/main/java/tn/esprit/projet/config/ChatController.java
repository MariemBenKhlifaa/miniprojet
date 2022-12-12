package tn.esprit.projet.config;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.projet.entities.Message;


@RestController

public class ChatController {
    @MessageMapping("/message")
    @SendTo("/chat/message")
    public String receiveMessage(Message message) {
        return message.getMessage();
    }
}