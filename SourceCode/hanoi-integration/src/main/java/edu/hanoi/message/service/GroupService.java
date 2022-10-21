package edu.hanoi.message.service;

import edu.hanoi.data.dao.GroupDAO;
import edu.hanoi.data.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;

@Service
public class GroupService {
    private final static Logger LOGGER = Logger.getLogger(GroupService.class);

    private Group groups;
    @Autowired
    GroupDAO groupDAO;
    public Group add(Group group){
        LOGGER.info("-----> Add group "+group.getName());
        return group;
    }

    public void handleMessage(Group groups){
        this.groups = groups;
    }
}
