package org.ite.oauth2.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.ite.oauth2.domain.User;
import org.ite.oauth2.user.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException(
                        "User has not been found"
                )
        );
        log.info("User :{}", user);
        CustomUserDetails customUserDetail = new CustomUserDetails();
        customUserDetail.setUser(user);
        return customUserDetail;
    }
}
