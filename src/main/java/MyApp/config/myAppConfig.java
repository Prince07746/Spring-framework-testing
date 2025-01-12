package MyApp.config;

import MyApp.BeanOne;
import MyApp.BeanTwo;
import MyApp.model.AdminUser;
import MyApp.model.TransactionUser;
import MyApp.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

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

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    CommandLineRunner commandLineRunner(AdminRepository adminRepository){
        return args ->{
            AdminUser user1 = new AdminUser("Prince","Matongo","davidkitoko13@Gmail.com",22);
            AdminUser user2 = new AdminUser("David","Tafar","tafar350@Gmail.com",32);

            adminRepository.save(user1);
            adminRepository.save(user2);
        };
    }

}
