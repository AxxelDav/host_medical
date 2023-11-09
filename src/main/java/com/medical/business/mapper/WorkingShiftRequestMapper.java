package com.medical.business.mapper;

import com.medical.domain.dto.request.WorkingShiftRequest;
import com.medical.domain.model.WorkingShift;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WorkingShiftRequestMapper {

    @Autowired
    private ModelMapper modelMapper;

    public WorkingShift toDomain(WorkingShiftRequest request) {
        return modelMapper.map(request, WorkingShift.class);

    }

    public List<WorkingShift> toDomain(List<WorkingShiftRequest> requests) {
        return requests
                .stream()
                .map(workingShift -> toDomain(workingShift))
                .collect(Collectors.toList());
    }

}
