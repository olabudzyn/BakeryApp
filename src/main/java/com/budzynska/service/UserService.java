package com.budzynska.service;

import com.budzynska.domain.User;
import com.budzynska.exception.ResourceNotFoundException;
import com.budzynska.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo repository;

    public User findUserById(Long id){
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user", "id", id));
    }

    public List<User> getAllUsers(){
        return repository.findAll();
    }

    public boolean addUser(User user){
        User userToCheck = repository.getUserByEmail(user.getEmail());
        if(userToCheck != null){
            return false;
        }
        repository.save(user);
        return true;
    }
}
