package org.golqmyus.service;

import org.golqmyus.model.dto.UserDTO;
import org.golqmyus.model.entity.UserEntity;

public interface UserService {
    UserEntity registerUser(UserDTO user);
    String loginUser(UserDTO user);
}
