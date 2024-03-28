package tn.esprit.coexist.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.coexist.dto.AuthenticationRequest;
import tn.esprit.coexist.dto.AuthenticationResponse;
import tn.esprit.coexist.service.AuthenticationService;
import tn.esprit.coexist.dto.RegisterRequest;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("register")
    public ResponseEntity<AuthenticationResponse> register
            (@RequestBody RegisterRequest request)throws IOException {
        System.out.println("Welcome : ");
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate
            (@RequestBody AuthenticationRequest request) {
        System.out.println("Welcome : "+request.getEmail());

        return ResponseEntity.ok(service.authenticate(request));
    }


}
