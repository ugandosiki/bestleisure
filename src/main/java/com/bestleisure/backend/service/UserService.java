package com.bestleisure.backend.service;

import com.bestleisure.backend.model.User;
import com.bestleisure.backend.repository.IUserRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    final IUserRepository iUserRepository;

    public UserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
    public void createUser(User user) throws ObjectNotFoundException {
        try {
            iUserRepository.save(user);
        } catch (ObjectNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
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
        try{
            iUserRepository.deleteById(id);
        }
        catch (IllegalArgumentException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deleteUser(String name)throws IllegalArgumentException {
        try{
            iUserRepository.deleteUserByName(name);
        }
        catch (IllegalArgumentException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
