package edu.hanoi.message;

import edu.hanoi.data.model.Group;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class GroupClientTest {
    public static void main(String[] args) {
        String address = "http://localhost:8080/group/add";
        HttpClientBuilder builder = HttpClientBuilder.create();
        CloseableHttpClient httpClient = builder.build();
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory(httpClient));

        Group group = new Group("Nhóm1 ", 1);
        ResponseEntity<Boolean> insertEntity = restTemplate.postForEntity(address, group, Boolean.class);
        System.out.println("From server "+insertEntity.getBody());
    }
}
