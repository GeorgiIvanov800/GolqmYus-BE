package org.golqmyus.web;

import org.golqmyus.model.dto.LoginDTO;
import org.golqmyus.model.dto.LoginEntity;
import org.golqmyus.model.dto.LoginResponse;
import org.golqmyus.model.dto.UserDTO;
import org.golqmyus.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("api/users")
public class UserLoginController {

    private final UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

//    @PostMapping("/login")
//    public ResponseEntity<LoginResponse> login(@RequestBody UserDTO  user) {
//            LoginResponse response = userService.loginUser(user);
//
//            if (response.success()) {
//                return ResponseEntity.ok(response);
//            } else {
//                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
//            }
//    }
    //TODO: Make a GlobalExceptionHandler Controller
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginEntity user) {
        LoginResponse loginResult = userService.loginWithJwt(user);

        LoginResponse response = new LoginResponse(
                loginResult.token(),
                loginResult.username(),
                loginResult.imgUrl()
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/check-username")
    public ResponseEntity<Boolean> checkUsernameExists(@RequestParam String username) {
        boolean exists = userService.usernameExists(username);
        return ResponseEntity.ok(exists);
    }


    @GetMapping("/check-email")
    public ResponseEntity<Boolean> checkEmailExists(@RequestParam String email) {
        boolean exists = userService.emailExists(email);
        System.out.println("exists: " + exists);
        return ResponseEntity.ok(exists);
    }
}



