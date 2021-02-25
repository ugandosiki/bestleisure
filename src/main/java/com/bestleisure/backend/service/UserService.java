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
    public boolean createUser(User user) throws ObjectNotFoundException {
        try {
            iUserRepository.save(user);
            return true;
        } catch (ObjectNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
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
    public boolean deleteUser(Long id) throws IllegalArgumentException {
        try{
            iUserRepository.deleteById(id);
            return true;
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteUser(String name)throws IllegalArgumentException {
        try{
            iUserRepository.deleteUserByName(name);
            return true;
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
