package com.medical.business.mapper;

import com.medical.domain.dto.response.UserResponse;
import com.medical.domain.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDtoMapper {

    @Autowired
    private ModelMapper modelMapper;

    public UserResponse toDto(User user) {
        return modelMapper.map(user, UserResponse.class);

    }

    public List<UserResponse> toDto(List<User> users) {
        return users
                .stream()
                .map(user -> toDto(user))
                .collect(Collectors.toList());
    }

}
