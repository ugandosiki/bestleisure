package com.bestleisure.backend.service;

import com.bestleisure.backend.model.Role;
import com.bestleisure.backend.model.User;
import com.bestleisure.backend.repository.IRoleRepository;
import com.bestleisure.backend.repository.IUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    private final IUserRepository iUserRepository;
    private final IRoleRepository iRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(IUserRepository iUserRepository, IRoleRepository iRoleRepository, PasswordEncoder passwordEncoder) {
        this.iUserRepository = iUserRepository;
        this.iRoleRepository = iRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void createUser(User user) {
        try {
            Role userRole = iRoleRepository.findRoleByName("ROLE_USER");
            user.setRole(userRole);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            iUserRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public User findByEmail(String email) {
        try {
            return iUserRepository.findUserByEmail(email);
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        User user = findByEmail(email);
        if (user != null) {
            if (passwordEncoder.matches(password, user.getPassword())) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User getOneUser(Long id) {
        return iUserRepository.getOne(id);
    }

    @Override
    public User getUserByName(String name) {
        return iUserRepository.findUserByName(name);
    }

    @Override
    public List<User> getAllUsers() {
        return iUserRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) throws IllegalArgumentException {
        try {
            iUserRepository.deleteById(id);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deleteUser(String name) throws IllegalArgumentException {
        try {
            iUserRepository.deleteUserByName(name);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
