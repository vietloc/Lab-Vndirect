package edu.hanoi.service.springhnservice;

import edu.hanoi.service.SpringHnserviceApplication;
import edu.hanoi.service.controller.UserRestServiceController;
import edu.hanoi.service.model.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringHnserviceApplication.class)
@WebAppConfiguration
class SpringHnserviceApplicationTests {
	@Autowired
	UserRestServiceController userRestServiceController;

	@Test
	void contextLoads() {
//		List<User> users = userRestServiceController.listUser();
//		Assert.assertTrue(users.size()>=0);
	}

}
