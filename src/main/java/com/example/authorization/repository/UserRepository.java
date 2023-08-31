package com.example.authorization.repository;

import com.example.authorization.model.UserImp;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private ConcurrentHashMap<UserImp, List<Authorities>> map = new ConcurrentHashMap<>();

    public UserRepository() {
        map.put(new UserImp("Admin", "1234"), List.of(Authorities.DELETE, Authorities.WRITE, Authorities.READ));
        map.put(new UserImp("User", "1234"), List.of(Authorities.WRITE, Authorities.READ));
    }

    public List<Authorities> getUserAuthorities(UserImp userImp) {
        return map.get(userImp);
    }
}
