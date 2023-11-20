package com.medical.domain.dto.response;

import com.medical.domain.model.Specialization;
import lombok.Data;

@Data
public class ModalityResponse {

    private Long id;
    private String desciption;
    private Specialization specialization;
}
