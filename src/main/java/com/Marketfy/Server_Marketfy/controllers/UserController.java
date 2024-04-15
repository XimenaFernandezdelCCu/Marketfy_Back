package com.Marketfy.Server_Marketfy.controllers;

import com.Marketfy.Server_Marketfy.entities.User;
import com.Marketfy.Server_Marketfy.entities.UsersExtra;
import com.Marketfy.Server_Marketfy.repos.UserRepository;
import com.Marketfy.Server_Marketfy.repos.UsersExtraRepository;
import com.Marketfy.Server_Marketfy.service.UserService;
import com.sun.security.auth.UserPrincipal;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    UserRepository repository;
    @Autowired
    UsersExtraRepository repositoryExtra;
    @Autowired
    UserService service;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private HttpSession httpSession;

    @GetMapping("/userId")
    public ResponseEntity<Object> getUserById(@RequestParam Integer id){
        Optional<User> userOptional = repository.findById(id);
        if (userOptional.isPresent()){
            User user = userOptional.get();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(user);
        }else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("USER NOT FOUND");

        }
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody Map<String, Object> user, HttpServletRequest request) {
        //Authenticate user
        ResponseEntity<Object> auth = service.LogUser(user);
        if (auth.getStatusCode() == HttpStatus.OK){
            HttpSession session = request.getSession(true);
            session.setAttribute("userId", auth.getBody());
        }
        return auth;
    }

    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(@RequestBody Map<String, Object> user) {
        return service.registerUser(user);
    }

//    @GetMapping("/userDetails")
//    public ResponseEntity<Object> getUserDetails(@RequestParam Integer id){
//        Optional<User> userOptional = repository.findById(id);
//        if (userOptional.isPresent()) {
//            List<String> myList = repository.getAllUserDetails(id);
//            Map<String, String> userDetails = new HashMap<>();
//
//            if (myList.isEmpty()){
//                userDetails.put("email", userOptional.get().getEmail());
//                userDetails.put("first", userOptional.get().getFirst());
//                userDetails.put("last", userOptional.get().getLast());
//                userDetails.put("preferred", null);
//                userDetails.put("bio", null);
//                userDetails.put("interest", null);
////                return ResponseEntity
////                        .status(HttpStatus.OK)
////                        .body(userDetails);
//            } else {
//                userDetails.put("email", myList.get(0));
//                userDetails.put("first", myList.get(1));
//                userDetails.put("last",  myList.get(2));
//                userDetails.put("preferred",  myList.get(3));
//                userDetails.put("bio",  myList.get(4));
//                userDetails.put("interest", myList.get(5));
//            }
//            return ResponseEntity
//                    .status(HttpStatus.OK)
//                    .body(userDetails);
//
//        } else {
//            return ResponseEntity
//                    .status(HttpStatus.BAD_REQUEST)
//                    .body("No user found");
//        }
//    }

    @GetMapping("/userDetails")
    public ResponseEntity<Object> getUserDetails(@RequestParam Integer id){
        Optional<User> userOptional = repository.findById(id);
        if (userOptional.isPresent()) {
            Map<String, String> userDetails = new HashMap<>();
            userDetails.put("email", userOptional.get().getEmail());
            userDetails.put("first", userOptional.get().getFirst());
            userDetails.put("last", userOptional.get().getLast());

            Optional<UsersExtra> extraOptional = repositoryExtra.findById(id);
            if (extraOptional.isPresent()){
                userDetails.put("preferred", extraOptional.get().getPreferred());
                userDetails.put("bio", extraOptional.get().getBio());
                userDetails.put("interest", extraOptional.get().getTags());


            } else {
                userDetails.put("preferred", null);
                userDetails.put("bio", null);
                userDetails.put("interest", null);
            }
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(userDetails);

        } else {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("No user found");
        }
    }

    @PostMapping("/editUserDetails")
    public ResponseEntity<Object> editUserDetails(@RequestBody Map<String, Object> changes ){
        return service.editUserDetails(changes);
    }





}
