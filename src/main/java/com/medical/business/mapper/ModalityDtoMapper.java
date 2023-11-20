package com.medical.business.mapper;

import com.medical.domain.dto.response.ModalityResponse;
import com.medical.domain.model.Modality;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ModalityDtoMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ModalityResponse toDto(Modality modality) {
        return modelMapper.map(modality, ModalityResponse.class);

    }

    public List<ModalityResponse> toDto(List<Modality> modalities) {
        return modalities
                .stream()
                .map(modality -> toDto(modality))
                .collect(Collectors.toList());
    }

}
