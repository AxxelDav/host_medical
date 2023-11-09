package com.medical.business.service.impl;

import com.medical.business.service.UserService;
import com.medical.common.util.ValidateParameterShiftRequest;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private ValidateParameterShiftRequest validateParameterShiftRequest;

    //TODO CRUD DE USER

    @Override
    public void ShiftRequest(String specialization, String month, String locale, String streetNumber, String street, String workingDay, String dayshift) throws Exception {
        validateParameterShiftRequest.validate(specialization, month, locale, streetNumber, street, workingDay, dayshift);

    }
}
