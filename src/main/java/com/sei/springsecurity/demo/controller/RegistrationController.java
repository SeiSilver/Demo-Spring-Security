package com.sei.springsecurity.demo.controller;

import com.sei.springsecurity.demo.entity.Role;
import com.sei.springsecurity.demo.entity.User;
import com.sei.springsecurity.demo.service.RoleService;
import com.sei.springsecurity.demo.service.UserService;
import com.sei.springsecurity.demo.user.CrmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    private Map<String, String> roles;

    @PostConstruct
    protected void loadRoles() {
// using hashmap, could also read this info from a database
        roles = new LinkedHashMap<>();
// key=the role, value=display to user
        List<Role> allroles = roleService.getALlRoles();

        for (Role i : allroles) {
            roles.put(i.getName(), i.getName().substring(i.getName().indexOf("_") + 1));
        }
    }

    // support to trim empty strings to null in form:form
    @InitBinder

    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/showRegistrationForm")
    public String showMyLoginPage(Model theModel) {
        theModel.addAttribute("crmUser", new CrmUser());
        theModel.addAttribute("roles", roles);
        return "registration-form";
    }

    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(
            @Valid @ModelAttribute("crmUser") CrmUser theCrmUser,
            BindingResult theBindingResult,
            Model theModel) {

        String userName = theCrmUser.getUserName();
        System.out.println("Processing registration form for: " + userName);

        // form validation
        if (theBindingResult.hasErrors()) {
            theModel.addAttribute("roles", roles);
            return "registration-form";
        }

        // check the database if user already exists
        User existing = userService.findByUserName(userName);
        if (existing != null) {
            theModel.addAttribute("crmUser", new CrmUser());
            theModel.addAttribute("registrationError", "User name already exists.");
            System.err.println("User name already exists.");
            return "registration-form";
        }
        // create user account

        System.out.println(theCrmUser.getFormRole());
        
//        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList();
//        authorities.add(new SimpleGrantedAuthority("ROLE_EMPLOYEE"));
//
//        String formRole = theCrmUser.getFormRole();
//        if (!formRole.equals("ROLE_EMPLOYEE")) {
//            authorities.add(new SimpleGrantedAuthority(formRole));
//        }

        userService.save(theCrmUser);

        System.out.println("Successfully created user: " + userName);

        return "registration-confirmation";
    }

}
