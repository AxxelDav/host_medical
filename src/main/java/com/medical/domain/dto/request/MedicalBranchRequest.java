package com.medical.domain.dto.request;

import lombok.Data;

@Data
public class MedicalBranchRequest {

    private String street;
    private Integer numberStreet;
    private String location;
}
