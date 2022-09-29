package lt.codeacademy.blog.controller;

import lt.codeacademy.blog.dto.User;
import lt.codeacademy.blog.service.UserService;
import lt.codeacademy.blog.validator.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/public/users")
public class UserController {

    private final UserValidator userValidator;
    private final UserService userService;

    public UserController(UserValidator userValidator, UserService userService) {

        this.userValidator = userValidator;
        this.userService = userService;
    }


    @GetMapping("/save")
    public String openUserRegistrationForm(Model model){
        model.addAttribute("user", new User());

        return "form/user";
    }

    @PostMapping("/save")
    public String createUser(@Valid User user, BindingResult bindingResult){
        userValidator.validate(user,bindingResult);
        if(bindingResult.hasErrors()){
            return "form/user";
        }
        userService.createUser(user);

        return "redirect:/login";
    }
}
