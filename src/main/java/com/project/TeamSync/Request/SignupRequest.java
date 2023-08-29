package com.project.TeamSync.Request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SignupRequest {
    private String name;
    private String email;
    private String password;
}
