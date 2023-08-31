package com.project.TeamSync.Request;

import lombok.Data;

@Data
public class CreateCommentRequest {
    private String text;
    private Long userId;
    private Long projectId;
}
