package com.medical.business.mapper;

import com.medical.domain.dto.ModalityDTO;
import com.medical.domain.dto.request.ModalityRequest;
import com.medical.domain.model.Modality;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ModalityRequestMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Modality toDomain(ModalityRequest request) {
        return modelMapper.map(request, Modality.class);

    }

    public List<Modality> toDomain(List<ModalityRequest> requests) {
        return requests
                .stream()
                .map(request -> toDomain(request))
                .collect(Collectors.toList());
    }

}
