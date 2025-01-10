package org.golqmyus.service.impl;

import org.golqmyus.model.dto.LoginResponse;
import org.golqmyus.model.dto.UserDTO;
import org.golqmyus.model.entity.UserEntity;
import org.golqmyus.model.entity.UserRoleEntity;
import org.golqmyus.model.enums.UserRoleEnum;
import org.golqmyus.repository.UserRepository;
import org.golqmyus.repository.UserRoleRepository;
import org.golqmyus.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final AuthenticationManager authManager;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository, AuthenticationManager authenticationManager, AuthenticationManager authManager, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.authManager = authManager;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserEntity registerUser(UserDTO userRegistration) {

        if (userRegistration == null) {
            throw new IllegalArgumentException("UserDTO cannot be null");
        }
            UserEntity user = mapToEntity(userRegistration);

        //Create a role entity every new user should have the role of USER
        UserRoleEntity userRole = userRoleRepository.findByRole(UserRoleEnum.ROLE_USER);

        // Handle empty imageUrl
        if (user.getImageUrl() == null || user.getImageUrl().isEmpty()) {
            user.setImageUrl("https://w7.pngwing.com/pngs/205/731/png-transparent-default-avatar-thumbnail.png"); // Default profile picture
        }
            user.setActive(true);
            user.setUserScore(0);
            user.setRegistrationDate(Instant.now());
            user.getRoles().add(userRole);
            userRepository.save(user);
        return user;
    }

    @Override
    public LoginResponse loginUser(UserDTO user) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.username(), user.password()));
            if (authentication.isAuthenticated()) {
                System.out.println("Authenticated: " + authentication);
                return new LoginResponse("Login successful", true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new LoginResponse("Invalid username or password", false);
        }
        return new LoginResponse("Login failed for unknown reasons", false);

    }


    private UserEntity mapToEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userDTO.email());
        userEntity.setPassword(passwordEncoder.encode(userDTO.password()));
        userEntity.setFirstName(userDTO.firstName());
        userEntity.setLastName(userDTO.lastName());
        userEntity.setUsername(userDTO.username());
        userEntity.setImageUrl(userDTO.imageUrl());
        return userEntity;
    }
}
