package com.medical.business.service;

public interface UserService {

    //TODO CRUD DE USER

    public void ShiftRequest(String specialization, String month, String locale, String streetNumber, String street, String workingDay, String dayshift) throws Exception;

}