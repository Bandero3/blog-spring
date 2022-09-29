package lt.codeacademy.blog.validator;

import lt.codeacademy.blog.dto.Post;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PostValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Post.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "postValidator.name.empty");
        ValidationUtils.rejectIfEmpty(errors, "description", "postValidator.description.empty");
        ValidationUtils.rejectIfEmpty(errors, "image", "postValidator.image.empty");
    }
}
