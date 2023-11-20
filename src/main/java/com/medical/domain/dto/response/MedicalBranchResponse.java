package com.medical.domain.dto.response;

import lombok.Data;

@Data
public class MedicalBranchResponse {

    private Long id;
    private String street;
    private Integer numberStreet;
    private String location;
}
