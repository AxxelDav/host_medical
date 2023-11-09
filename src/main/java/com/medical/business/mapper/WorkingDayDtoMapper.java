package com.medical.business.mapper;

import com.medical.domain.dto.WorkingDayDTO;
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

    public WorkingDayDTO toDto(WorkingDay workingDay) {
        return modelMapper.map(workingDay, WorkingDayDTO.class);

    }

    public List<WorkingDayDTO> toDto(List<WorkingDay> workingDays) {
        return workingDays
                .stream()
                .map(workingDay -> toDto(workingDay))
                .collect(Collectors.toList());
    }

}
