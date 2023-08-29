package com.project.TeamSync.Service;

import com.project.TeamSync.Entity.Role;
import com.project.TeamSync.Entity.User;
import com.project.TeamSync.Repository.UserRepository;
import com.project.TeamSync.Request.SigninRequest;
import com.project.TeamSync.Request.SignupRequest;
import com.project.TeamSync.Response.SigninResponse;
import com.project.TeamSync.Response.SignupResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public SignupResponse singup(SignupRequest request){
        User user=User.builder().name(request.getName()).email(request.getEmail()).role(Role.USER).password(passwordEncoder.encode(request.getPassword())).build();
        userRepository.save(user);

        String jwtToken=jwtService.generateToken(user);
        return SignupResponse.builder().token(jwtToken).build();
    }

    public SigninResponse signin(SigninRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
        User user=userRepository.findByEmail(request.getEmail());
        String jwtToken=jwtService.generateToken(user);
        return SigninResponse.builder().token(jwtToken).build();
    }
}
