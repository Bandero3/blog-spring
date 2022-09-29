package lt.codeacademy.blog.exception;

import java.util.UUID;

public class PostNotExistException extends RuntimeException{
    private final UUID postId;

    public PostNotExistException(UUID productId) {
        this.postId = productId;
    }

    public UUID getPostId() {
        return postId;
    }
}
