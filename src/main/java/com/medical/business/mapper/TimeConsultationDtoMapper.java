package com.medical.business.mapper;

import com.medical.domain.dto.response.TimeConsultationResponse;
import com.medical.domain.model.TimeConsultation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TimeConsultationDtoMapper {

    @Autowired
    private ModelMapper modelMapper;

    public TimeConsultationResponse toDto(TimeConsultation timeConsultation) {
        return modelMapper.map(timeConsultation, TimeConsultationResponse.class);

    }

    public List<TimeConsultationResponse> toDto(List<TimeConsultation> timeConsultations) {
        return timeConsultations
                .stream()
                .map(request -> toDto(request))
                .collect(Collectors.toList());
    }

}
