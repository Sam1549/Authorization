package com.example.authorization.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


import java.lang.annotation.*;
import java.util.Objects;

public class UserImp implements User {
    @NotBlank(message = "user can not be empty")
    @Size(min = 3, max = 20, message = "user must be between 3 and 20 characters")
    private String name;
    @NotBlank(message = "password can not be empty")
    @Size(min = 3, max = 20, message = "password must be between 3 and 20 characters")
    private String password;

    public UserImp() {
    }

    public UserImp(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserImp userImp = (UserImp) o;
        return Objects.equals(name, userImp.name) && Objects.equals(password, userImp.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password);
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return User.class;
    }
}
