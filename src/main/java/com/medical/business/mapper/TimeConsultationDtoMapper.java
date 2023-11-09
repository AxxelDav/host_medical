package com.medical.business.mapper;

import com.medical.domain.dto.TimeConsultationDTO;
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
public class TimeConsultationDtoMapper {

    @Autowired
    private ModelMapper modelMapper;

    public TimeConsultationDTO toDto(TimeConsultation timeConsultation) {
        return modelMapper.map(timeConsultation, TimeConsultationDTO.class);

    }

    public List<TimeConsultationDTO> toDto(List<TimeConsultation> timeConsultations) {
        return timeConsultations
                .stream()
                .map(request -> toDto(request))
                .collect(Collectors.toList());
    }

}
