package com.example.demo.controllers.form.validation;

import com.example.demo.controllers.form.SignupForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SignupFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return SignupForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SignupForm form = (SignupForm) target;

        System.out.println("Start validator");
        System.out.println(form.getUserName());
        System.out.println(form.getPassword());
        System.out.println(form.getRePassword());
        System.out.println("End   validator");

        String password = form.getPassword();
        String rePassword = form.getRePassword();

        if(password == null || rePassword == null) {
            return;
        }

        if(!password.equals(rePassword)) {
            errors.rejectValue("password", "signup.error.password.compare", "入力したパスワードが違っています");
        }
    }
}
