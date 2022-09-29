package lt.codeacademy.blog.controller;

import lt.codeacademy.blog.dto.Post;
import lt.codeacademy.blog.service.CommentService;
import lt.codeacademy.blog.service.PostService;
import lt.codeacademy.blog.validator.PostValidator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.UUID;

@Controller
public class PostController {

    private final PostValidator postValidator;
    private final PostService postService;
    private final CommentService commentService;

    public PostController(PostValidator postValidator, PostService postService, CommentService commentService) {
        this.postValidator = postValidator;
        this.postService = postService;
        this.commentService = commentService;
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/posts/save")
    public String openCreatePost(Model model) {
        model.addAttribute("post", new Post());

        return "form/post";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/posts/save")
    public String createPost(@Valid Post post, BindingResult bindingResult) {

        postValidator.validate(post,bindingResult);
        if(bindingResult.hasErrors()) {
            return "form/post";
        }

        postService.createPost(post);

        return "redirect:/public/posts";
    }


    @GetMapping("/public/posts")
    public String showPosts(Model model, @SortDefault(sort = {"name"}, caseSensitive = false) Pageable pageable){

        model.addAttribute("postsByPage", postService.getPosts(pageable));
        return "posts";
    }

    @GetMapping("/public/posts/{id}")
    public String openDetailPage(@PathVariable UUID id, Model model, Pageable pageable){
        model.addAttribute("post", postService.getPost(id));
        model.addAttribute("comments", commentService.getComments(pageable));
        return "postDetails";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/posts/{id}/update")
    public String showUpdateForm(@PathVariable UUID id, Model model) {
        model.addAttribute("post", postService.getPost(id));
        return "form/post";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/posts/{id}/update")
    public String updatePost(@Valid Post post, BindingResult bindingResult) {
        postValidator.validate(post,bindingResult);
        if(bindingResult.hasErrors()) {
            return "form/post";
        }

        postService.updatePost(post);

        return "redirect:/public/posts";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("posts/{id}/delete")
    public String deletePost(@PathVariable UUID id){
        postService.delete(id);
        return "redirect:/public/posts";
    }
}
