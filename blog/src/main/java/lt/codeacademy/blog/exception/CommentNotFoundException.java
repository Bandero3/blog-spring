package lt.codeacademy.blog.exception;

import java.util.UUID;

public class CommentNotFoundException extends RuntimeException{
    private final UUID id;

    public CommentNotFoundException(UUID id){
        this.id = id;
    }
}
