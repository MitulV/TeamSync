package com.project.TeamSync.Response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SigninResponse {
    private String token;
}
