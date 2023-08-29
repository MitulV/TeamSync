package com.project.TeamSync.Controller;

import com.project.TeamSync.Request.SigninRequest;
import com.project.TeamSync.Request.SignupRequest;
import com.project.TeamSync.Response.SigninResponse;
import com.project.TeamSync.Response.SignupResponse;
import com.project.TeamSync.Service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/api/auth/signup")
    public ResponseEntity<SignupResponse> signup(@RequestBody SignupRequest request){
        return ResponseEntity.ok(authenticationService.singup(request));
    }

    @PostMapping("/api/auth/signin")
    public ResponseEntity<SigninResponse> signin(@RequestBody SigninRequest request){
        return ResponseEntity.ok(authenticationService.signin(request));
    }

    @GetMapping("/api/hello")
    public String hello(){
        return "Hello World";
    }
}
