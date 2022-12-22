package com.catalogue.gamecatalogue.service;

import com.catalogue.gamecatalogue.dao.RoleRepository;
import com.catalogue.gamecatalogue.dao.UserRepository;
import com.catalogue.gamecatalogue.entity.User;
import com.catalogue.gamecatalogue.model.CreateUserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Transactional
    public long saveUser(CreateUserDTO dto) {
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        String passwd = user.getPassword();
        String encodedPass = passwordEncoder.encode(passwd);
        user.setPassword(encodedPass);
        user.setValid(true);
        user.setRoles(new HashSet<>(roleRepository.findAllById(dto.getRoles())));
        user = userRepository.save(user);
        return user.getId();
//        return 1;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }
}
