package com.medical.domain.dto.request;

import lombok.Data;

@Data
public class UserRequest {

    private String name;
    private String lastName;
    private Integer identificationNumber;
    private String phoneNumber;
}
