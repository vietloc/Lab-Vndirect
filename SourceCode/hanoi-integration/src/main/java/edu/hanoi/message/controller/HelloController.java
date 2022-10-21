package edu.hanoi.message.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    DirectChannel stdoutChannel;

    @RequestMapping(value = "/say")
    public boolean say(@RequestParam String name){
        return stdoutChannel.send(MessageBuilder.withPayload(name).build());
    }
}
