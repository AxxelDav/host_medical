package com.medical.business.mapper;

import com.medical.domain.dto.ModalityDTO;
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

    public ModalityDTO toDto(Modality modality) {
        return modelMapper.map(modality, ModalityDTO.class);

    }

    public List<ModalityDTO> toDto(List<Modality> modalities) {
        return modalities
                .stream()
                .map(modality -> toDto(modality))
                .collect(Collectors.toList());
    }

}
