package com.medical.business.mapper;

import com.medical.domain.dto.response.WorkingShiftResponse;
import com.medical.domain.model.WorkingShift;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WorkingShiftDtoMapper {

    @Autowired
    private ModelMapper modelMapper;

    public WorkingShiftResponse toDto(WorkingShift workingShift) {
        return modelMapper.map(workingShift, WorkingShiftResponse.class);

    }

    public List<WorkingShiftResponse> toDto(List<WorkingShift> workingShifts) {
        return workingShifts
                .stream()
                .map(workingShift -> toDto(workingShift))
                .collect(Collectors.toList());
    }

}
