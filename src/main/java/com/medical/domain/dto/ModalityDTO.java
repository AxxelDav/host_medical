package com.medical.domain.dto;

import com.medical.domain.model.Specialization;
import lombok.Data;

@Data
public class ModalityDTO {

    private Long id;
    private String desciption;
    private Specialization specialization;
}
