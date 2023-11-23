package com.medical.business.facade.impl;

import com.medical.business.facade.UserFacade;
import com.medical.business.mapper.UserDtoMapper;
import com.medical.business.mapper.UserRequestMapper;
import com.medical.business.service.UserService;
import com.medical.common.exception.IllegalArgumentException;
import com.medical.common.exception.NonExistingResourceException;
import com.medical.domain.dto.response.UserResponse;
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
    public UserResponse findById(Long userId) throws NonExistingResourceException {
        User user = userService.findById(userId);
        return userDtoMapper.toDto(user);
    }

    @Override
    public UserResponse create(UserRequest request) throws IllegalArgumentException  {
        User userToBeCreated = userRequestMapper.toDomain(request);
        User userCreated = userService.create(userToBeCreated);
        return userDtoMapper.toDto(userCreated);
    }

    @Override
    public UserResponse update(UserRequest request, Long userId) throws NonExistingResourceException, IllegalArgumentException {
        User userToBeUpdated = userRequestMapper.toDomain(request);
        userToBeUpdated.setId(userId);
        User userUpdated = userService.update(userToBeUpdated);
        return userDtoMapper.toDto(userUpdated);
    }

    @Override
    public void delete(Long userId) throws NonExistingResourceException {
        userService.delete(userId);
    }
}
