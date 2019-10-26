package com.budzynska.controller;

import com.budzynska.dto.UserDTO;
import com.budzynska.mapper.UserMapper;
import com.budzynska.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final UserMapper mapper;

    @GetMapping
    public List<UserDTO> getAllUsers(){
        return mapper.toUserDTOs(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id){
        return mapper.toUserDTO(userService.findUserById(id));
    }

    @PostMapping
    public boolean addUser(@RequestBody UserDTO user){
        return userService.addUser(mapper.toUser(user));
    }
}
