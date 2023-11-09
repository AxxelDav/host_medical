package com.medical.business.mapper;

import com.medical.domain.dto.request.WorkingDayRequest;
import com.medical.domain.dto.request.WorkingMonthRequest;
import com.medical.domain.model.WorkingDay;
import com.medical.domain.model.WorkingMonth;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WorkingDayRequestMapper {

    @Autowired
    private ModelMapper modelMapper;

    public WorkingDay toDomain(WorkingDayRequest request) {
        return modelMapper.map(request, WorkingDay.class);

    }

    public List<WorkingDay> toDomain(List<WorkingDayRequest> requests) {
        return requests
                .stream()
                .map(request -> toDomain(request))
                .collect(Collectors.toList());
    }

}
