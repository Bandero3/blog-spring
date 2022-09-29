package lt.codeacademy.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.codeacademy.blog.entity.PostEntity;

import javax.validation.constraints.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private UUID id;
    private String name;
    private String description;
    private String image;
    private String date;

    public static Post convert(PostEntity entity){
        return new Post(entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getImage(),
                entity.getDate());
    }
}
