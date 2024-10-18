package org.ite.oauth2.init;

import jakarta.annotation.PostConstruct;

import org.ite.oauth2.domain.Authority;
import org.ite.oauth2.domain.User;
import org.ite.oauth2.user.AuthorityRepository;
import org.ite.oauth2.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInit {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    void init() {
        if (authorityRepository.count() > 0) {
            return;
        }
        System.out.println("DataInit.init");
        Authority write = new Authority();
        write.setName("write");
        Authority read = new Authority();
        read.setName("read");

        authorityRepository.saveAll(List.of(write, read));

        if (userRepository.count() > 0) {
            return;
        }
        User user1 = new User();
        user1.setUsername("seu");
        user1.setPassword(passwordEncoder.encode("123"));
        user1.setAuthorities(List.of(write, read));
        user1.setIsDeleted(false);
        user1.setFullName("mengseu thoeng");

        User user2 = new User();
        user2.setUsername("reki");
        user2.setPassword(passwordEncoder.encode("password"));
        user2.setIsDeleted(false);
        user2.setFullName("mengseu thoeng");
        user2.setAuthorities(List.of(read));

        userRepository.saveAll(List.of(user1, user2));
    }
}
