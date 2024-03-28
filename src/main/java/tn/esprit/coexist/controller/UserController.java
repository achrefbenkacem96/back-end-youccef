package tn.esprit.coexist.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.esprit.coexist.dto.ChangePasswordRequest;
import tn.esprit.coexist.entity.User;
import tn.esprit.coexist.repository.UserRepository;
import tn.esprit.coexist.service.UserService;

import java.security.Principal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
@CrossOrigin("*")
public class UserController {


    private UserService userService;
    private final UserRepository userRepository;
    // build create User REST API
    @PostMapping("/addUser")
    public User createUser(@RequestBody User user){
      //  User savedUser = userService.createUser(user);
        return userRepository.save(user);
                //new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    // build get user by id REST API
    // http://localhost:8080/api/users/1
    /*@GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable("id") Integer userId){
        return userRepository.findById(userId);//.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        //User user = userService.getUserById(userId);
        //return new ResponseEntity<>(user, HttpStatus.OK);
    }
*/
    // Build Get All Users REST API
    // http://localhost:8080/api/users
    @GetMapping("/getAllUser")
   // @PreAuthorize("hasRole('ADMIN')")
    public List<User> getAllUsers(){
       // return userRepository.findAll();

        return userService.getAllUser();
        //List<User> users = userService.getAllUser();
        //return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Build Update User REST API
    @PutMapping("/updateUser/{id}")
    // http://localhost:8080/api/users/1
    public ResponseEntity<User>  updateUser(@PathVariable("id") Integer userId,
                                           @RequestBody User user){
        //User user = userRepository.findById(userId);
        //return userRepository.save(user);
        user.setUserId(userId);
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // Build Delete User REST API
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Integer userId){
        userRepository.deleteById(userId);
        return ResponseEntity.ok().build();
        //userService.deleteUser(userId);
        //return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }

    @PatchMapping("/changemdp")
    public ResponseEntity<?> changePassword(
          //  @PathVariable("id") Integer userId,
            @RequestBody ChangePasswordRequest request
            , Principal connectedUser
    ) {
        userService.changePassword(
                //userId,
                request
                , connectedUser
        );
        return ResponseEntity.ok().build();
    }
}
