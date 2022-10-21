package edu.hanoi.service.springhnservice;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import edu.hanoi.service.model.Group;
import edu.hanoi.service.model.User;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RunWith(JUnit4.class)
public class SpringServiceClientTests {
    private RestTemplate restTemplate;
    
    @Before
    public void setUp(){
        HttpClientBuilder builder = HttpClientBuilder.create();
        CloseableHttpClient httpClient = builder.build();
        restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory(httpClient));
    }
    @Test
    public void contextLoads(){
//        String address = "http://localhost:8080/list/users/";
//        ResponseEntity<List>entity = restTemplate.getForEntity(address, List.class);
//        List<User> users = (List<User>) entity.getBody();
//        Assert.assertTrue(users.size()>0);
//        for (int i =0;i < users.size(); i++){
//            System.out.println(users);
//        }
//        ResponseEntity<List> groupEntity = restTemplate.getForEntity(address, List.class);
//        List<Group> groups = (List<Group>) entity.getBody();
//        Assert.assertTrue(groups.size() > 0);
//
//        for (int i =0;i < groups.size(); i++){
//            System.out.println(groups);
//        }


//        User user = new User();
//        user.setUsername("promax14");
//        user.setPassword("password-23");
//        user.setAge(46);
//        user.setGroupId(401);
//        user.setEmail("ten739541@gmail.com");

//        String address = "http://localhost:8080/add/user/";
//        ResponseEntity<String> insertEntity = restTemplate.postForEntity(address, user, String.class);
//        Assert.assertEquals(user.getUsername(),insertEntity.getBody());
//        String address = "http://localhost:8080/get/user/testdb";
//        ResponseEntity<User> getEntity = restTemplate.getForEntity(address, User.class);
//        Assert.assertEquals("123", getEntity.getBody().getPassword());

//        String address = "http://localhost:8080/list/groups/";
//        ResponseEntity<Group[]> groupEntity = restTemplate.getForEntity(address, Group[].class);
//        Group[] groups = groupEntity.getBody();
//        Assert.assertTrue(groups.length >= 0);
//
//        for(int i = 0; i < groups.length; i++){
//            System.out.println(groups[i].getId());
//        }

//        String address = "http://localhost:8080/delete/user/testdb";
//        ResponseEntity<Void> delEntity = restTemplate.getForEntity(address, Void.class);
//
//        address = "http://localhost:8080/get/user/testdb";
//        ResponseEntity<User> getEntity = restTemplate.getForEntity(address, User.class);
//        Assert.assertEquals(null, getEntity.getBody());
        String address = "http://localhost:8080/get/user/testdb";
        ResponseEntity<User> getEntity = restTemplate.getForEntity(address, User.class);
        User user = getEntity.getBody();
        Assert.assertNotNull(user);

        user.setPassword("654321");
        address = "http://localhost:8080/update/user/";
        restTemplate.postForEntity(address, user, Void.class);

        address = "http://localhost:8080/get/user/testdb";
        ResponseEntity<User> getEntity2 = restTemplate.getForEntity(address, User.class);
        Assert.assertEquals(user.getPassword(), getEntity2.getBody().getPassword());
    }
}
