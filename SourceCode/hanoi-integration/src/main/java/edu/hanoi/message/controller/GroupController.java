package edu.hanoi.message.controller;

import edu.hanoi.data.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
public class GroupController {
    @Autowired
    private MessageChannel groupChannel;

    @RequestMapping(value = "/group/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Boolean say(@RequestBody Group group){
        return groupChannel.send(MessageBuilder.withPayload(group).build());
    }
}
