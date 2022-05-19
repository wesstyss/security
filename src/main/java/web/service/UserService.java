package web.service;

import web.model.User;
import javax.validation.Valid;
import java.util.List;

public interface UserService {

    List<User> getAllUsers ();
    User getUserById(long id);
    void addUser(User user);
    void removeUser(long id);
    void updateUser(User user);
    User getUserByLogin(String username);
    void addDefaultUser();
    User passwordCoder(User user);
}