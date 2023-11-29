package com.medical.domain.dto.request;

import lombok.Data;

@Data
public class PatientRequest {

    private String name;
    private String lastName;
    private Integer identificationNumber;
    private String phoneNumber;
}
