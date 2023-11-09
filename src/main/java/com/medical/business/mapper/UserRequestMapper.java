package com.medical.business.mapper;

import com.medical.domain.dto.request.UserRequest;
import com.medical.domain.dto.request.WorkingDayRequest;
import com.medical.domain.model.User;
import com.medical.domain.model.WorkingDay;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserRequestMapper {

    @Autowired
    private ModelMapper modelMapper;

    public User toDomain(UserRequest request) {
        return modelMapper.map(request, User.class);

    }

    public List<User> toDomain(List<UserRequest> requests) {
        return requests
                .stream()
                .map(request -> toDomain(request))
                .collect(Collectors.toList());
    }

}
