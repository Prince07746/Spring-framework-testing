package MyApp.controller;


import MyApp.model.UserClient;
import MyApp.service.MyService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class MyController {

    private final MyService myService;

    @Autowired
    public MyController(MyService myService){
        this.myService = myService;
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



}
