package com.example.authorization.service;

import com.example.authorization.model.UserImp;
import com.example.authorization.repository.Authorities;
import com.example.authorization.exception.InvalidCredentials;
import com.example.authorization.exception.UnauthorizedUser;
import com.example.authorization.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(UserImp userImp) {
        if (isEmpty(userImp.getName()) || isEmpty(userImp.getPassword())) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(userImp);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + userImp.getName());
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
