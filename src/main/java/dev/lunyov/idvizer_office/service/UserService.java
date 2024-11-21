package dev.lunyov.idvizer_office.service;

import dev.lunyov.idvizer_office.entity.User;
import dev.lunyov.idvizer_office.repositoryWrapper.UserRepositoryWrapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepositoryWrapper userRepositoryWrapper;

    public UserService(UserRepositoryWrapper userRepositoryWrapper) {
        this.userRepositoryWrapper = userRepositoryWrapper;
    }

    public User findOrCreateUser(String email, String phone) {
        User user = userRepositoryWrapper.findByEmail(email);
        if (user == null) {
            user = new User();
            user.setEmail(email);
            user.setPhone(phone);
            userRepositoryWrapper.save(user);
        }
        return user;
    }

    public User findUserByEmail(String email) {
         return    userRepositoryWrapper.findByEmail(email);
    }
}