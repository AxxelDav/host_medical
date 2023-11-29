package com.medical.business.mapper;

import com.medical.domain.dto.request.ProfessionalRequest;
import com.medical.domain.model.Professional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProfessionalRequestMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Professional toDomain(ProfessionalRequest request) {
        return modelMapper.map(request, Professional.class);
    }

    public List<Professional> toDomain(List<ProfessionalRequest> requests) {
        return requests
                .stream()
                .map(request -> toDomain(request))
                .collect(Collectors.toList());
    }

}
