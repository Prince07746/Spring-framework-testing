package MyApp.controller;


import MyApp.model.UserClient;
import MyApp.DTO.UserClientBank;
import MyApp.service.MyService;

// you can access the all request with this

// all about spring boot , mvc , where autowired for dependency injection
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

// log info about the app
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;

@RestController
@RequestMapping("/user")
public class MyController {

    private final MyService myService;
    private final RestTemplate restTemplate;
    private static final Logger logger = LoggerFactory.getLogger(MyController.class);

    @Value("${bank.service.url}")
    private String bankUrl;


    @Autowired
    public MyController(MyService myService,RestTemplate restTemplate){
        this.myService = myService;
        this.restTemplate = restTemplate;
    }



   @GetMapping
   public List<UserClient> getUsers(){
        return myService.findAll();
   }

   @GetMapping("/{id}")
    public UserClient getUserById(@PathVariable("id") int userId){
        return myService.findUserById(userId);
   }

   @GetMapping("/getUser")
   public UserClient getUserByName(@RequestParam(value = "name",required = false) String name,
                                   @RequestParam(value = "lastName",required = false) String lastName){
        if(name != null){
            return myService.findUserByName(name);
        } else if(lastName != null){
            return myService.findUserByLastName(lastName);
        }
      return null;
   }


   @PostMapping
   public ResponseEntity<UserClient> addUser(@RequestBody UserClient userClient){
        myService.addUser(userClient);
        return  ResponseEntity.ok().header("User-added","ok").body(userClient);

   }
   @GetMapping("/delete")
    public ResponseEntity<String> deleteAllUsers(){
        myService.deleteAll();
        return ResponseEntity.ok().header("User-Deleted","ok").body("Database deleted");
   }

   @GetMapping("/delete/{id}")
    public ResponseEntity<UserClient> deleteUserById(@PathVariable("id") int userId){
       UserClient userClient = myService.findUserById(userId);
       myService.deleteById(userId);
      return userClient.getId() >= 0 ?
              ResponseEntity.ok().header("User-Deleted","ok").body(userClient)
              : ResponseEntity.ok().header("User-Deleted","fail").body(new UserClient());

   }


   @GetMapping("/{id}/bank")
    public ResponseEntity<UserClientBank> getUserDetailsBank(@PathVariable("id") int userId){


        try {

            String url = bankUrl.replace("{id}",String.valueOf(userId));

            UserClientBank userClientBank = restTemplate.getForObject(url, UserClientBank.class);
            return ResponseEntity.ok(userClientBank);

        } catch (Exception e){
            logger.error("Error fetching bank details for user ID: {}", userId, e);
            return ResponseEntity.status(500).body(null);
        }

   }



}
