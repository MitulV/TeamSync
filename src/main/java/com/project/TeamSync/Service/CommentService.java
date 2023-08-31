package com.project.TeamSync.Service;

import com.project.TeamSync.Entity.Comment;
import com.project.TeamSync.Entity.Project;
import com.project.TeamSync.Entity.Team;
import com.project.TeamSync.Entity.User;
import com.project.TeamSync.Repository.CommentRepository;
import com.project.TeamSync.Repository.ProjectRepository;
import com.project.TeamSync.Repository.UserRepository;
import com.project.TeamSync.Request.CreateCommentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;

    public Comment create(CreateCommentRequest request){
        Comment comment=Comment.builder().text(request.getText()).build();
        if(request.getUserId()!=null && request.getProjectId()!=null){
            User user=userRepository.findById(request.getUserId()).orElse(null);
            Project project=projectRepository.findById(request.getProjectId()).orElse(null);
            if(user!=null && project!=null){
                comment.setUser(user);
                comment.setProject(project);
                commentRepository.save(comment);
            }
        }

        return null;
    }

    public Comment get(Long id){
        return commentRepository.findById(id).orElse(null);
    }

    public List<Comment> get(){
        return commentRepository.findAll();
    }

    public boolean update(Long id,Comment comment){
        Comment existingComment=commentRepository.findById(id).orElse(null);
        if(existingComment!=null){
            if(comment.getText()!=null){
                existingComment.setText(comment.getText());
            }

            commentRepository.save(existingComment);
            return true;
        }
        return false;
    }

    public boolean delete(Long id){
        Comment comment=commentRepository.findById(id).orElse(null);
        if(comment!=null){
            commentRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
