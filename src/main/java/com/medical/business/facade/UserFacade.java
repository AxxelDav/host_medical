package com.medical.business.facade;

import com.medical.domain.dto.UserDTO;
import com.medical.domain.dto.request.UserRequest;

public interface UserFacade {

    UserDTO getUserById(Long UserId) throws Exception;

    UserDTO createUser(UserRequest request);

    UserDTO updateUser(UserRequest request, Long userId) throws Exception;

    void deleteUser(Long UserId) throws Exception;

}
