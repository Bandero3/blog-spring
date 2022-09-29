package lt.codeacademy.blog.controller;

import lt.codeacademy.blog.dto.Comment;
import lt.codeacademy.blog.dto.Post;
import lt.codeacademy.blog.dto.User;
import lt.codeacademy.blog.service.CommentService;
import lt.codeacademy.blog.service.PostService;
import lt.codeacademy.blog.validator.CommentValidator;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Controller
public class CommentController {

    private final CommentValidator commentValidator;
    private final CommentService commentService;
    private final PostService postService;

    public CommentController(CommentValidator commentValidator, CommentService commentService, PostService postService) {
        this.commentValidator = commentValidator;
        this.commentService = commentService;
        this.postService = postService;
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/comment/save/{id}")
    public String openCreateComment(@PathVariable UUID id, Model model) {
        model.addAttribute("comment", new Comment());
        model.addAttribute("post", postService.getPost(id));
        return "form/comment";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/comment/save/{id}")
    public String createComment(@Valid Comment comment, @PathVariable UUID id, @AuthenticationPrincipal User user, BindingResult bindingResult) {

        commentValidator.validate(comment,bindingResult);
        if(bindingResult.hasErrors()) {
            return "form/comment";
        }

        Post post = postService.getPost(id);
        comment.setPost(post);
        comment.setDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        comment.setUser(user);
        commentService.createComment(comment);

        return "redirect:/public/posts/{id}";
    }


    @PreAuthorize("isAuthenticated()")
    @GetMapping("comment/update/{id}")
    public String updateForm(@PathVariable UUID id, Model model) {
        model.addAttribute("comment", commentService.getComment(id));
        return "form/comment";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("comment/update/{id}")
    public String updateComment(@PathVariable UUID id, @Valid Comment comment, BindingResult bindingResult) {

        commentValidator.validate(comment,bindingResult);
        if(bindingResult.hasErrors()) {
            return "form/comment";
        }

        comment.setUser(commentService.getComment(id).getUser());

        comment.setPost(commentService.getComment(id).getPost());

        commentService.updateComment(comment);

        return "redirect:/public/posts/" + commentService.getComment(id).getPost().getId().toString();
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("comment/delete/{id}")
    public String deleteComment(@PathVariable UUID id) {

        UUID postId = commentService.getComment(id).getPost().getId();

        commentService.deleteComment(id);

        return "redirect:/public/posts/" + postId.toString();
    }

}
