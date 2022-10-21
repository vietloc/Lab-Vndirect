package edu.java.spring;

import org.springframework.beans.factory.DisposableBean;

import java.util.List;

public class HelloClazz implements DisposableBean {

    private List<JavaClazz> clazzes;

    public List<JavaClazz> getClazzes() {
        return clazzes;
    }

    public void setClazzes(List<JavaClazz> clazzes) {
        this.clazzes = clazzes;
    }

    public String message;

    public HelloClazz() {
        message = "From Constructor: Say hello everyone!";
    }

    public HelloClazz(int person) {
        message = "From Constructor: Say hello to: " +person+" person(s)!";
    }

    public HelloClazz(HelloClazz clazz){
        message = clazz.message;
    }

    public void setMessage(String message){
        this.message = "Call From Setter: " +message;
    }

    public String getMessage() {
        return message;
    }

    public void printMessage(){
        System.out.println("Your Message: " + message);
    }

    //co the goi ham nay trong beans.xml de in qua App.java
    private void initMessage(){
        System.out.println("Calling int method....");
        message = "From init method: Say hello bean!";
    }
//    private void release(){
//        message =null;
//        System.out.println("Message is null");
//    }

    @Override
    public void destroy() throws Exception {
        message = null;
        System.out.println("Message is null");
    }
}
