package com.project.TeamSync.Request;

import lombok.Data;

@Data
public class CreateProjectRequest {
    private String name;
    private String description;
    private Long teamId;

}
