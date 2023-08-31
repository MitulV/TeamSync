package com.project.TeamSync.Controller;

import com.project.TeamSync.Entity.Comment;
import com.project.TeamSync.Entity.Project;
import com.project.TeamSync.Entity.Team;
import com.project.TeamSync.Request.CreateCommentRequest;
import com.project.TeamSync.Service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/{id}")
    public ResponseEntity<Comment> get(@PathVariable Long id){
        return ResponseEntity.ok(commentService.get(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<Comment>> get(){
        return ResponseEntity.ok(commentService.get());
    }

    public ResponseEntity<Comment> create(CreateCommentRequest request){
        return ResponseEntity.ok(commentService.create(request));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Boolean> update(@PathVariable Long id, @RequestBody Comment comment){
        return ResponseEntity.ok(commentService.update(id,comment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return ResponseEntity.ok(commentService.delete(id));
    }
}
