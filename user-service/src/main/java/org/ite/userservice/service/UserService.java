package org.ite.userservice.service;

import org.ite.userservice.domain.User;

import java.util.List;

public interface UserService {

    void createUser(User user);

    User getUser(String id);

    List<User> getUsers();

}
