package com.medical.domain.dto.response;

import lombok.Data;

@Data
public class PatientResponse {

    private Long id;
    private String name;
    private String lastName;
    private Integer identificationNumber;
    private String phoneNumber;
}
