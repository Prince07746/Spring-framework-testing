package MyApp.controller;


import MyApp.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class MyController {

    private final MyService myService;

    @Autowired
    public MyController(MyService myService){
        this.myService = myService;
    }


    @GetMapping("/home")
    public String getAll(){
        return myService.findAll();
    }
}
