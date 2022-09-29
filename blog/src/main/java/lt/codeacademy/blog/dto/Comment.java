package lt.codeacademy.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.codeacademy.blog.entity.CommentEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private UUID id;
    private String comment;
    private String date;
    private Post post;
    private User user;

    public static Comment convert(CommentEntity commentEntity){
        Post post = Post.convert(commentEntity.getPostEntity());
        User user = User.convert(commentEntity.getUserEntity());

        return new Comment(commentEntity.getId(), commentEntity.getComment(), commentEntity.getDate(), post, user);
    }
}
