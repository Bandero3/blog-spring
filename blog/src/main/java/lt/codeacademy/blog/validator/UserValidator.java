package lt.codeacademy.blog.validator;

import lt.codeacademy.blog.dto.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "userValidator.name.empty");
        ValidationUtils.rejectIfEmpty(errors, "surname", "userValidator.surname.empty");
        ValidationUtils.rejectIfEmpty(errors, "username", "userValidator.username.empty");
        ValidationUtils.rejectIfEmpty(errors, "email", "userValidator.email.empty");
        ValidationUtils.rejectIfEmpty(errors, "country", "userValidator.country.empty");
        ValidationUtils.rejectIfEmpty(errors, "city", "userValidator.city.empty");
        ValidationUtils.rejectIfEmpty(errors, "password", "userValidator.password.empty");
        ValidationUtils.rejectIfEmpty(errors, "repeatPassword", "userValidator.repeatPassword.empty");
    }
}
