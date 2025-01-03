package MyApp;


import org.junit.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

@SpringBootApplication(scanBasePackages = "MyApp")
public class MyApp {

    String name;

    public static void main(String[] args){


        ApplicationContext context = new AnnotationConfigApplicationContext("MyApp");


        BeanOne bean = context.getBean(BeanOne.class);
        System.out.println(bean.getName());
        bean.display();

    }

}
