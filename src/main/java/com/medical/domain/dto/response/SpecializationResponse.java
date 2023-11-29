package com.medical.domain.dto.response;

import com.medical.domain.model.Modality;
import lombok.Data;

@Data
public class SpecializationResponse {

    private Long id;
    private String description;
    private ModalityResponse modality;
}
