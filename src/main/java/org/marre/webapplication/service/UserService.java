package org.marre.webapplication.service;

import org.marre.webapplication.model.User;
import org.springframework.stereotype.Service;

/**
 * @author :marRE
 * @Description:
 * @Date :2024/5/28
 */

@Service
public interface UserService {

    User Login (User user);

    User addUser(User user);

    User delUser(User user);

    User findUserById(int id);


}
