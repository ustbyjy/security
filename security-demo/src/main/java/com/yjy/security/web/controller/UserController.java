package com.yjy.security.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.yjy.security.dto.User;
import com.yjy.security.dto.UserQueryCondition;
import com.yjy.security.exception.UserNotExistException;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping
    public User create(@Valid @RequestBody User user, BindingResult errors) {
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
        }

        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());

        user.setId("1");

        return user;
    }

    @PutMapping("/{id:\\d+}")
    public User update(@Valid @RequestBody User user, BindingResult errors) {
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                FieldError fieldError = (FieldError) error;
                System.out.println(fieldError.getField() + ": " + error.getDefaultMessage());
            }
        }

        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());

        return user;
    }

    @DeleteMapping("/{id:\\d+}")
    public void update(@PathVariable String id) {
        System.out.println(id);
    }

    @GetMapping()
    @JsonView(User.UserSimpleView.class)
    public List<User> query(UserQueryCondition condition, @PageableDefault(page = 1, size = 10, sort = {"username,asc"}) Pageable pageable) {
        System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getSort());

        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());

        return users;
    }

    @GetMapping(value = "/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable String id) {

        throw new UserNotExistException(id);

//        System.out.println(id);
//
//        User user = new User();
//        user.setUsername("tom");
//
//        return user;
    }

}
