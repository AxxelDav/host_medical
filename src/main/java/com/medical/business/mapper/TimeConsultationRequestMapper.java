package com.medical.business.mapper;

import com.medical.domain.dto.request.TimeConsultationRequest;
import com.medical.domain.dto.request.UserRequest;
import com.medical.domain.model.TimeConsultation;
import com.medical.domain.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TimeConsultationRequestMapper {

    @Autowired
    private ModelMapper modelMapper;

    public TimeConsultation toDomain(TimeConsultationRequest request) {
        return modelMapper.map(request, TimeConsultation.class);

    }

    public List<TimeConsultation> toDomain(List<TimeConsultationRequest> requests) {
        return requests
                .stream()
                .map(request -> toDomain(request))
                .collect(Collectors.toList());
    }

}
