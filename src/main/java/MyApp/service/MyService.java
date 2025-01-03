package MyApp.service;


import MyApp.model.UserClient;
import MyApp.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyService {


    private MyRepository myRepository;

    @Autowired
    public MyService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }


    public List<UserClient> findAll(){
        List<UserClient> list = myRepository.findAll();
        list.add(new UserClient("prince","matongo",22));
        list.add(new UserClient("david","kitoko",25));
        list.add(new UserClient("isaac","mour",31));
        return list;
    }

    public void addUser(){
        myRepository.save(new UserClient("alain","matongo",38));
    }
}
