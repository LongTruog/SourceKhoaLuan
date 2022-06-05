package com.buysmartweb.service;

import com.buysmartweb.entity.User;
import com.buysmartweb.modelutil.PasswordDTO;

public interface UserService {
    boolean registerUser(User user);
    boolean checkExist(String email);
    User getCurrentUser();
    void updateUser(int id, User userRequest);
    boolean updatePassword(PasswordDTO passwordDTO);
}
