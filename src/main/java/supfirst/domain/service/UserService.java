package supfirst.domain.service;


import java.util.Collection;
import java.util.Optional;

import supfirst.entity.User;
import supfirst.domain.entity.UserCreateForm;

public interface UserService {

    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    User create(UserCreateForm form);

}
