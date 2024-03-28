package tn.esprit.coexist.service;


import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.coexist.dto.AuthenticationRequest;
import tn.esprit.coexist.dto.AuthenticationResponse;
import tn.esprit.coexist.dto.RegisterRequest;
import tn.esprit.coexist.config.JwtService;
import tn.esprit.coexist.entity.User;
import tn.esprit.coexist.repository.UserRepository;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final FileUploadService fileUploadService;

    public AuthenticationResponse register(RegisterRequest request) throws IOException {
        // Créez l'utilisateur avec les données de la requête
        var user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode((request.getPassword())))
                .phoneNumber(request.getPhoneNumber())
                .Address(request.getAddress())
                .roleName(request.getRoleName())
                .build();

        // Sauvegardez l'utilisateur dans la base de données
        userRepository.save(user);

        // Générez le token JWT
        var jwtToken = jwtService.generateToken(user);

        var authenticationResponse = AuthenticationResponse.builder()
                .token(jwtToken)
                .email(user.getEmail())
                .username(user.getUsername())
                .roleName(user.getRoleName().toString())
                .build();

        // Affichez un message de bienvenue dans la console
        System.out.println("Welcome: " + user.getUsername());

        // Renvoyez l'objet AuthenticationResponse
        return authenticationResponse;
    }
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();

        var jwtToken = jwtService.generateToken(user);
        System.out.println("ROle of logged user : " + user.getRoleName());
        System.out.println("token of logged user : " + jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
