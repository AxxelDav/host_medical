package com.medical.business.mapper;

import com.medical.domain.dto.response.WorkingDayResponse;
import com.medical.domain.model.WorkingDay;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WorkingDayDtoMapper {

    @Autowired
    private ModelMapper modelMapper;

    public WorkingDayResponse toDto(WorkingDay workingDay) {
        return modelMapper.map(workingDay, WorkingDayResponse.class);

    }

    public List<WorkingDayResponse> toDto(List<WorkingDay> workingDays) {
        return workingDays
                .stream()
                .map(workingDay -> toDto(workingDay))
                .collect(Collectors.toList());
    }

}
