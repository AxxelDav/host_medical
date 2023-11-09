package com.medical.business.mapper;

import com.medical.domain.dto.request.WorkingMonthRequest;
import com.medical.domain.model.WorkingMonth;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WorkingMonthRequestMapper {

    @Autowired
    private ModelMapper modelMapper;

    public WorkingMonth toDomain(WorkingMonthRequest request) {
        return modelMapper.map(request, WorkingMonth.class);

    }

    public List<WorkingMonth> toDomain(List<WorkingMonthRequest> requests) {
        return requests
                .stream()
                .map(request -> toDomain(request))
                .collect(Collectors.toList());
    }

}
