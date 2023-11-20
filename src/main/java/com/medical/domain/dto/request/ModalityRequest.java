package com.medical.domain.dto.request;

import com.medical.domain.model.Specialization;
import lombok.Data;

@Data
public class ModalityRequest {

    private String desciption;
    private SpecializationRequest specialization;
}
