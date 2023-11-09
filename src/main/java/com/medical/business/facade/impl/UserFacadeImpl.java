package com.medical.business.facade.impl;

import com.medical.business.facade.UserFacade;
import com.medical.business.mapper.UserDtoMapper;
import com.medical.business.mapper.UserRequestMapper;
import com.medical.business.service.UserService;
import com.medical.domain.dto.UserDTO;
import com.medical.domain.dto.request.UserRequest;
import com.medical.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserFacadeImpl implements UserFacade {

    @Autowired
    private UserDtoMapper userDtoMapper;

    @Autowired
    private UserRequestMapper userRequestMapper;

    @Autowired
    private UserService userService;



    @Override
    public UserDTO getUserById(Long userId) throws Exception {
        User user = userService.getUserById(userId);
        return userDtoMapper.toDto(user);
    }

    @Override
    public UserDTO createUser(UserRequest request) {
        User userToBeCreated = userRequestMapper.toDomain(request);
        User userCreated = userService.createUser(userToBeCreated);
        return userDtoMapper.toDto(userCreated);
    }

    @Override
    public UserDTO updateUser(UserRequest request) throws Exception {
        User userToBeUpdated = userRequestMapper.toDomain(request);
        User userUpdated = userService.updateUser(userToBeUpdated);
        return userDtoMapper.toDto(userUpdated);
    }

    @Override
    public void deleteUser(Long userId) throws Exception {
        userService.deleteUser(userId);
    }
}
