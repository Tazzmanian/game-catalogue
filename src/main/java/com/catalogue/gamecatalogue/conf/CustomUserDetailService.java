package com.catalogue.gamecatalogue.conf;

import com.catalogue.gamecatalogue.dao.UserRepository;
import com.catalogue.gamecatalogue.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service("userDetailsService")
@Transactional
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Wrong credentials"));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(), user.isValid(), true, true,
                true, user.getRoles().stream()
                .map(x -> new SimpleGrantedAuthority(x.getName())).collect(Collectors.toSet()));
    }
}
