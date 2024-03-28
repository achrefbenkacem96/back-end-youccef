package tn.esprit.coexist.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.coexist.dto.ChangePasswordRequest;
import tn.esprit.coexist.entity.RoleName;
import tn.esprit.coexist.entity.User;
import tn.esprit.coexist.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.Principal;
import java.util.*;



@Aspect
@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public User createUser(User user){
      /*  if (!user.getEmail().contains("@")){
            log.info("Votre mail invalide");
            throw  new RuntimeException("Votre mail invalide");
        }
        if (!user.getEmail().contains(".")){
            throw  new RuntimeException("Votre mail invalide");
        }
        if (user.getEmail().isEmpty()){
            throw  new RuntimeException("Votre mail invalide");
        }

        Optional<User> userOptional = this.userRepository.findByEmail(user.getEmail());
        if (userOptional.isPresent()){
            throw  new RuntimeException("Votre mail est déjà utilisé");
        }
        tring mdpCrypte = this.passwordEncoer().encode(user.getPassword());
        user.setPassword(mdpCrypte);

       Role roleUtilisateur = new Role();
        roleUtilisateur.setRoleName(RoleName.STUDENT);
        user.setRole(roleUtilisateur);

*/
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer userId){

    userRepository.deleteById(userId);
    }
    /*public List<User> getAllUser(){
        return userRepository.findAll();
    }
    public User getUserById(Integer userId){
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.get();
    }*/
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
    public User updateUser(User user){
        User existingUser = userRepository.findById(user.getUserId()).get();
        existingUser.setUsername(user.getUsername());
        existingUser.setPhoneNumber(user.getPhoneNumber());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
        return updatedUser;
    }
    public void changePassword(ChangePasswordRequest request, Principal connectedUser) {

        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        // check if the current password is correct
        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }
        // check if the two new passwords are the same
        if (!request.getNewPassword().equals(request.getConfirmationPassword())) {
            throw new IllegalStateException("Password are not the same");
        }

        // update the password
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));

        // save the new password
        userRepository.save(user);
    }

  /*  public void updatePassword(Integer id, ChangePasswordRequest updatePasswordDto) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            String storedHashedPassword = user.get().getPassword();
            if (passwordEncoder.matches(updatePasswordDto.getCurrentPassword(), storedHashedPassword)) {
                user.get().setPassword(passwordEncoder.encode(updatePasswordDto.getNewPassword()));
                userRepository.save(user.get());
            } else {
                throw new RuntimeException("Password update failed");  // Generic error message
            }
        } else {
            throw new RuntimeException("User not found");
        }
    }*/

/*
public boolean checkEmail(String email){
        return
    }
*/
public User getUserById(Integer userId) {
    Optional<User> optionalUser = userRepository.findById(userId);
    return optionalUser.orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
}


}
