package org.golqmyus.config;

import org.golqmyus.model.entity.UserEntity;
import org.golqmyus.model.entity.UserRoleEntity;
import org.golqmyus.model.enums.UserRoleEnum;
import org.golqmyus.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final String IMAGE_PATH = "https://i.ytimg.com/vi/uW7nrkK4GLs/hqdefault.jpg?sqp=-oaymwEmCOADEOgC8quKqQMa8AEB-AHOBYAC0AWKAgwIABABGGUgZShlMA8=&rs=AOn4CLAdjCfiw4EV0m05yr7UYjehu0AfJA";
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
            if (userRepository.count() == 0) {
                UserEntity user = new UserEntity();
                user.setFirstName("Georgi");
                user.setLastName("Ivanov");
                user.setUsername("golqmyus");
                user.setPassword(passwordEncoder.encode("12345"));
                user.setEmail("golqmyus@gmail.com");
                user.setRegistrationDate(Instant.now());
                user.setImageUrl(IMAGE_PATH);
                user.setActive(true);
                user.setRoles(List.of(createUserRoleEntity()));
                userRepository.save(user);

                System.out.println("Admin user created successfully");
            } else {
                System.out.println("Admin user already exists");
            }
    }

    private UserRoleEntity createUserRoleEntity() {
        UserRoleEntity adminRole = new UserRoleEntity();
            adminRole.setRole(UserRoleEnum.ROLE_ADMIN);
            return adminRole;
    }
}

