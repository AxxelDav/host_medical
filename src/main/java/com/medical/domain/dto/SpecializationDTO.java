package com.medical.domain.dto;

import com.medical.domain.model.Modality;
import lombok.Data;

@Data
public class SpecializationDTO {

    private Long id;
    private String desciption;
    private Modality modality;
}
