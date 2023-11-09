package com.medical.domain.dto;

import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    private String name;
    private String lastName;
    private Integer identificationNumber;
    private String phoneNumber;
}
