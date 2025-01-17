package org.golqmyus.service;

import org.golqmyus.model.dto.LoginDTO;
import org.golqmyus.model.dto.LoginEntity;
import org.golqmyus.model.dto.LoginResponse;
import org.golqmyus.model.dto.UserDTO;
import org.golqmyus.model.entity.UserEntity;

public interface UserService {
    UserEntity registerUser(UserDTO user);
    LoginResponse loginUser(UserDTO user);
    LoginResponse loginWithJwt(LoginEntity user);

    boolean usernameExists(String username);

    boolean emailExists(String email);
}
