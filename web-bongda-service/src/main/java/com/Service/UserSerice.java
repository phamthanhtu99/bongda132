package com.Service;

import com.dto.UserDTO;

public interface UserSerice {
    UserDTO save(UserDTO dto);
    UserDTO FindOneByUsername(String username);
}
