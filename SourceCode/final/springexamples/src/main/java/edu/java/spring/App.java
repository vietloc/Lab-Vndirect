package edu.java.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args )
    {
        //tao doi tuong context lay gtri tu file beans.xml
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        context.registerShutdownHook();
//        //tao doi tuong obj lay gtri trong id=...
//        HelloClazz obj = (HelloClazz) context.getBean("helloJavaClazz");
//        obj.printMessage();
//        System.out.println(obj);
//
//        HelloClazz obj2 = (HelloClazz) context.getBean("helloJavaClazz2");
//        obj2.printMessage();
//        System.out.println(obj2);
//        System.out.println(obj == obj2);
//
//        HelloClazz obj3 = (HelloClazz) context.getBean("helloJavaClazz");
//        obj2.printMessage();
//        System.out.println(obj3);
//        System.out.println(obj3 == obj2);
//            HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
//            obj.sayHello();
//        JavaClazz clazz = (JavaClazz) context.getBean("jee01");
//        System.out.println("Map Implement is " + clazz.getStudents().getClass());
//        System.out.println("There are "+clazz.getStudents().size()+"in the class");
//        HelloClazz clazz = (HelloClazz) context.getBean("helloJavaClazz");
//        System.out.println("Total classes is " + clazz.getClazzes().size());
//        HelloWorld obj= (HelloWorld) context.getBean("helloWorld");
//        obj.sayHello();
        context.start();
        context.stop();
    }
}
