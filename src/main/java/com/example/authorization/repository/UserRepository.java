package com.example.authorization.repository;

import com.example.authorization.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private ConcurrentHashMap<User,List<Authorities>> map = new ConcurrentHashMap<>();

    public UserRepository() {
        map.put(new User("Admin","1234"),List.of(Authorities.DELETE,Authorities.WRITE,Authorities.READ));
        map.put(new User("User","1234"),List.of(Authorities.WRITE,Authorities.READ));
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        return map.get(new User(user,password));
    }
}
