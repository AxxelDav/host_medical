package com.medical.domain.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class WorkingMonthDTO {

    private Long id;
    private String month;
}
