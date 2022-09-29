package lt.codeacademy.blog.service;

import lt.codeacademy.blog.dto.Post;
import lt.codeacademy.blog.entity.PostEntity;
import lt.codeacademy.blog.exception.PostNotExistException;
import lt.codeacademy.blog.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public void createPost(Post post){
        post.setDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        postRepository.save(PostEntity.convert(post));
    }

    public Page<Post> getPosts(Pageable pageable){
        return postRepository.findAll(pageable)
                .map(Post::convert);
    }

    public Post getPost(UUID id){

        return postRepository.findById(id)
                .map(Post::convert)
                .orElseThrow(() -> new PostNotExistException(id));
    }

    public void updatePost(Post post){
        post.setDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        postRepository.save(PostEntity.convert(post));
    }

    public void delete(UUID id){

        postRepository.deleteById(id);
    }
}

