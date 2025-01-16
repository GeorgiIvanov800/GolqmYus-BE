package org.golqmyus.service.impl;

import org.golqmyus.exceotion.InvalidCredentialsException;
import org.golqmyus.model.dto.LoginDTO;
import org.golqmyus.model.dto.LoginEntity;
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
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final AuthenticationManager authManager;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;

    public UserServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository, AuthenticationManager authenticationManager, AuthenticationManager authManager, PasswordEncoder passwordEncoder, JWTService jwtService) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.authManager = authManager;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
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
                return new LoginResponse("Login successful", "true", user.imageUrl());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new LoginResponse("Invalid username or password", "false", "");
        }
        return new LoginResponse("Login failed for unknown reasons", "false", "");

    }


//    @Override
//    public String loginWithJwt(LoginDTO user) {
//
//        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.username(), user.password()));
//        if (authentication.isAuthenticated()) {
//            return jwtService.generateToken(user.username());
//        }
//
//        return "fail";
//    }

    @Override
    public LoginResponse loginWithJwt(LoginEntity user) {
        try {
            // Authenticate the user
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.username(), user.password())
            );

            UserEntity userEntity = userRepository.findByUsername(user.username())
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));

            // Generate and return the JWT token upon successful authentication
            String token =  jwtService.generateToken(user.username());
            return new LoginResponse(token, user.username(), userEntity.getImageUrl());
        } catch (AuthenticationException e) {
            // Throw custom exception for invalid credentials
            throw new InvalidCredentialsException("Invalid username or password");
        }
    }

    @Override
    public boolean usernameExists(String username) {

        return userRepository.findByUsername(username).isPresent();
    }

    @Override
    public boolean emailExists(String email) {

        return userRepository.findByEmail(email).isPresent();
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
