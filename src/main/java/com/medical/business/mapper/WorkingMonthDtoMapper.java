package com.medical.business.mapper;

import com.medical.domain.dto.WorkingMonthDTO;
import com.medical.domain.dto.WorkingShiftDTO;
import com.medical.domain.model.WorkingMonth;
import com.medical.domain.model.WorkingShift;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WorkingMonthDtoMapper {

    @Autowired
    private ModelMapper modelMapper;

    public WorkingMonthDTO toDto(WorkingMonth workingMonth) {
        return modelMapper.map(workingMonth, WorkingMonthDTO.class);

    }

    public List<WorkingMonthDTO> toDto(List<WorkingMonth> workingMonths) {
        return workingMonths
                .stream()
                .map(workingMonth -> toDto(workingMonth))
                .collect(Collectors.toList());
    }

}
