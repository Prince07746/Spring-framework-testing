package MyApp.controller;


import MyApp.model.UserClient;
import MyApp.service.MyService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class MyController {

    private final MyService myService;

    @Autowired
    public MyController(MyService myService){
        this.myService = myService;
    }


    @GetMapping("/")
    public String home(){
        return "Hello, World";
    }

    @GetMapping("/message")
    public String message(HttpServletRequest request){
        return "This is a message from, "+request.getParameter("name");
    }

    @GetMapping("/add")
    public String addUser(){
        myService.addUser();
        return "user added";
    }

    @GetMapping("/users")
    public List<UserClient> getAll(){
        return myService.findAll();
    }
}
