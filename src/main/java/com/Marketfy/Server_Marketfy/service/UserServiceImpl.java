package com.Marketfy.Server_Marketfy.service;

import com.Marketfy.Server_Marketfy.entities.User;
import com.Marketfy.Server_Marketfy.entities.UsersExtra;
import com.Marketfy.Server_Marketfy.repos.UsersExtraRepository;
import com.Marketfy.Server_Marketfy.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository repository;
    @Autowired
    UsersExtraRepository userExtraRepository;

    // Login
    @Override
    public ResponseEntity<Object> LogUser(Map<String, Object> user){
        ResponseEntity<Object> response = null;
        List<User> existingUser = repository.findByEmail((String) user.get("email"));
        if (!existingUser.isEmpty()){
            // check that passwords match
            String existingPass = existingUser.get(0).getPass();
            if(existingPass.equals((String) user.get("pass"))){

                Integer id = existingUser.get(0).getUserId();

                Map<String, Object> result = new HashMap<>();
                result.put("id", id);
                result.put("first", existingUser.get(0).getFirst());

                Optional<UsersExtra> optionalUserExtra =  userExtraRepository.findById(id);
                if(optionalUserExtra.isPresent()){
                    result.put("preferred", optionalUserExtra.get().getPreferred());
                } else {
                    result.put("preferred", null);
                }
                response= ResponseEntity
                        .status(HttpStatus.OK)
                        .body(result);
            } else {
                response= ResponseEntity
                        .status(HttpStatus.UNAUTHORIZED)
                        .body("Incorrect Password");
            }
        } else {
            response = ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("No user with email:  " + (String) user.get("email") + " exists.");
        }
        return response;
    }

    @Override
    public ResponseEntity<Object> registerUser(Map<String, Object> userData) {
        String email = (String) userData.get("email");
        String pass = (String) userData.get("pass");
        String first = (String) userData.get("first");
        String last = (String) userData.get("last");

        // Check if the email already exists
        List<User> existingUser = repository.findByEmail(email);
        if (!existingUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Email already exists");
        }

        // Create a new user
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setPass(pass);
        newUser.setFirst(first);
        newUser.setLast(last);
        newUser.setRole("user");
        newUser.setActive(false);

        // Save the new user
        repository.save(newUser);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("User created successfully");
    }

    @Override
    public ResponseEntity<Object> editUserDetails(Map<String, Object> changes){
        String id = (String) changes.get("id");
        Integer userId = Integer.valueOf(id);
        Optional<User> optionalUser = repository.findById(userId);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            user.setFirst((String) changes.get("first"));
            user.setLast((String) changes.get("last"));
            user.setEmail((String) changes.get("email"));
            repository.save(user);

            Optional<UsersExtra> optionalUserExtra =  userExtraRepository.findById(userId);
            if(optionalUserExtra.isPresent()){
                UsersExtra userExtra = optionalUserExtra.get();
                userExtra.setPreferred((String) changes.get("preferred"));
                userExtra.setBio((String) changes.get("bio"));
                userExtraRepository.save(userExtra);
            } else {
                UsersExtra newExtra = new UsersExtra();
                newExtra.setUserId(userId);
                newExtra.setPreferred((String) changes.get("preferred"));
                newExtra.setBio((String) changes.get("bio"));
                userExtraRepository.save(newExtra);
            }

//            userExtra.setTags((String) changes.get("tags"));
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("User updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User not Found");
        }
    }





} //last ONE
