package tn.esprit.coexist.service.Comment;


import org.springframework.http.ResponseEntity;
import tn.esprit.coexist.entity.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    ResponseEntity<?> addComment_to_Subject(Comment comment, Integer idSub, Integer idUser);
    public List<Comment> getCommentsBySubject(Integer subjectId);
    public ResponseEntity<?> updateComment_to_Subject(Comment existingComment, Comment newComment) ;
    public Optional<Comment> getCommentById(Integer commentId);
}
