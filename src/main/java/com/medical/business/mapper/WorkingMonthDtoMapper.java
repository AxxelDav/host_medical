package com.medical.business.mapper;

import com.medical.domain.dto.response.WorkingMonthResponse;
import com.medical.domain.model.WorkingMonth;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WorkingMonthDtoMapper {

    @Autowired
    private ModelMapper modelMapper;

    public WorkingMonthResponse toDto(WorkingMonth workingMonth) {
        return modelMapper.map(workingMonth, WorkingMonthResponse.class);

    }

    public List<WorkingMonthResponse> toDto(List<WorkingMonth> workingMonths) {
        return workingMonths
                .stream()
                .map(workingMonth -> toDto(workingMonth))
                .collect(Collectors.toList());
    }

}
