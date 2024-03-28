package tn.esprit.coexist.service;

import tn.esprit.coexist.dto.ChangePasswordRequest;
import tn.esprit.coexist.entity.User;

import java.security.Principal;
import java.util.List;

public interface UserService {
    User createUser(User user);

    // boolean checkEmail(String email);
     void deleteUser(Integer userId);
    List<User> getAllUser();
    //User getUserById(Integer userId);
    User updateUser(User user);
    void changePassword(ChangePasswordRequest request, Principal connectedUser);
    //void updatePassword(Integer id, ChangePasswordRequest updatePasswordDto);
}
