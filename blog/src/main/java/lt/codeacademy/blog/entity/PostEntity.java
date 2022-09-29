package lt.codeacademy.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.codeacademy.blog.dto.Post;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "posts")
public class PostEntity {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)", updatable = false)
    @Type(type = "uuid-char")
    private UUID id;
    private String name;
    private String description;
    private String image;
    private String date;

    @OneToMany(mappedBy = "postEntity", cascade = CascadeType.ALL)
    private List<CommentEntity> comments;

    public PostEntity(UUID id, String name, String description, String image, String date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.date = date;
    }

    public static PostEntity convert(Post p){
        return new PostEntity(p.getId(),
                p.getName(),
                p.getDescription(),
                p.getImage(),
                p.getDate());
    }
}
