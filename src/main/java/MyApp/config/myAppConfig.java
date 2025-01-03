package MyApp.config;

import MyApp.BeanOne;
import MyApp.BeanTwo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class myAppConfig {

    @Bean
    public BeanOne getBeanOne(@Value("prince") String name,@Value("Matongo") String lastName){
        return new BeanOne(name,lastName,getBeanTwo());
    }
    @Bean
    public BeanTwo getBeanTwo(){
        return new BeanTwo();
    }


}
