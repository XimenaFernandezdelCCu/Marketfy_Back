package com.Marketfy.Server_Marketfy.service;

import com.Marketfy.Server_Marketfy.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface UserService {
    public ResponseEntity<Object> LogUser(Map<String, Object> user);
    ResponseEntity<Object> registerUser(Map<String, Object> user);

    ResponseEntity<Object> editUserDetails(Map<String, Object> changes);

}
