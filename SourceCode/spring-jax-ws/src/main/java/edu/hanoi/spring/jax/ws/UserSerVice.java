package edu.hanoi.spring.jax.ws;

import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
@Component
public class UserSerVice {
    @WebMethod(operationName = "say")
    public String sayHello(String name){
        return "Hanoi Java say hello to " + name;
    }
}
