package com.leadproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.leadproject.model.Lead;
import com.leadproject.service.LeadService;

@RestController
public class LeadController {

    @Autowired
    private LeadService leadService;

//    @GetMapping("/posts/{postId}/comments")
//    public Page<Comment> getAllCommentsByPostId(@PathVariable (value = "postId") Long postId,
//                                                Pageable pageable) {
//        return commentRepository.findByPostId(postId, pageable);
//    }

    @PostMapping("/leads")
    public Lead create(@RequestBody Lead lead)
    {
        Lead p = leadService.create(lead);
        return p;
    }

    @GetMapping("/leads/{id}")
    public Lead getLead(@PathVariable Long id)
    {
        return leadService.get(id);
    }

    @GetMapping("/leads")
    public List<Lead> getLeads()
    {
        return leadService.getAll();
    }

    @PutMapping("/leads/{id}")
    public Lead update(@RequestBody Lead lead, @PathVariable Long id)
    {
        Lead leadUpdated = leadService.update(lead, id);
        return leadUpdated;
    }

    @DeleteMapping("/leads/{id}")
    public void deleteLead(@PathVariable Long id)
    {
        leadService.delete(id);
    }

    @DeleteMapping("/leads")
    public void deleteLeads()
    {
        leadService.deleteAll();
    }

//    @PostMapping("/posts/{postId}/comments")
//    public Comment createComment(@PathVariable (value = "postId") Long postId,
//                                 @Valid @RequestBody Comment comment) {
//        return postRepository.findById(postId).map(post -> {
//            comment.setPost(post);
//            return commentRepository.save(comment);
//        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
//    }

//    @PutMapping("/posts/{postId}/comments/{commentId}")
//    public Comment updateComment(@PathVariable (value = "postId") Long postId,
//                                 @PathVariable (value = "commentId") Long commentId,
//                                 @Valid @RequestBody Comment commentRequest) {
//        if(!postRepository.existsById(postId)) {
//            throw new ResourceNotFoundException("PostId " + postId + " not found");
//        }
//
//        return commentRepository.findById(commentId).map(comment -> {
//            comment.setText(commentRequest.getText());
//            return commentRepository.save(comment);
//        }).orElseThrow(() -> new ResourceNotFoundException("CommentId " + commentId + "not found"));
//    }
//
//    @DeleteMapping("/posts/{postId}/comments/{commentId}")
//    public ResponseEntity<?> deleteComment(@PathVariable (value = "postId") Long postId,
//                              @PathVariable (value = "commentId") Long commentId) {
//        return commentRepository.findByIdAndPostId(commentId, postId).map(comment -> {
//            commentRepository.delete(comment);
//            return ResponseEntity.ok().build();
//        }).orElseThrow(() -> new ResourceNotFoundException("Comment not found with id " + commentId + " and postId " + postId));
//    }
}
