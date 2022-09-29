package lt.codeacademy.blog.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Setter
@Getter
@Configuration
@PropertySource("classpath:blog.properties")
public class Blog {
    @Value("${blog.name}")
    private String name;
    @Value("${blog.phone}")
    private String phone;
    @Value("${blog.email}")
    private String email;
    @Value("${blog.copy.rights}")
    private String copyRight;
    @Value("${blog.address}")
    private String address;
}
