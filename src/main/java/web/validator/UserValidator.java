package web.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import web.model.User;
import web.service.UserService;

public class UserValidator implements Validator {

    @Autowired
    private UserService userService;
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
    User user = (User) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"username","Required");
        if(user.getUsername().length() < 8 || user.getUsername().length() > 32){
            errors.rejectValue("username","Size.userFrom.username");
        }
        if(userService.getUserByLogin(user.getName())!=null){
            errors.rejectValue("username","Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","Required");
        if(user.getPassword().length()<8||user.getPassword().length()>32){
            errors.rejectValue("password","Size.userForm.password");
        }
        if(!user.getConfirmPassword().equals((user.getPassword()))){
            errors.rejectValue("confirmPassword","Different.userForm.password");
        }
    }
}
