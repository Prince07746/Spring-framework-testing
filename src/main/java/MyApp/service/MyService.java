package MyApp.service;


import MyApp.model.UserClient;
import MyApp.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MyService {


    private final MyRepository myRepository;

    @Autowired
    public MyService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }


    public List<UserClient> findAll(){
        return myRepository.findAll();
    }

    public void addUser(UserClient user){
        myRepository.save(user);
    }

    public UserClient findUserById(int id){
        return findAll().stream().
                filter(userList ->  userList.getId() == id).
                findFirst().
                orElse(null);
    }

    public UserClient findUserByName(String name){
        return findAll().stream().
                filter(userList -> userList.getName().equals(name)).
                findFirst().orElse(null);
    }
    public UserClient findUserByLastName(String lastName){
        return findAll().stream().
                filter(userList -> userList.getLastName().equals(lastName)).
                findFirst().orElse(null);
    }

    public void deleteAll(){
        myRepository.deleteAll();
    }

    public void deleteById(int id){
        myRepository.deleteById(id);
    }


}
