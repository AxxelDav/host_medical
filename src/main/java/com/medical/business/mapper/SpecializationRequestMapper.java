package com.medical.business.mapper;

import com.medical.domain.dto.request.SpecializationRequest;
import com.medical.domain.dto.request.UserRequest;
import com.medical.domain.model.Specialization;
import com.medical.domain.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SpecializationRequestMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Specialization toDomain(SpecializationRequest request) {
        return modelMapper.map(request, Specialization.class);

    }

    public List<Specialization> toDomain(List<SpecializationRequest> requests) {
        return requests
                .stream()
                .map(request -> toDomain(request))
                .collect(Collectors.toList());
    }

}
