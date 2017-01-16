package com.happ.controller;

import com.happ.model.User;
import com.happ.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ievgenii.tsybaiev on 09.01.2017.
 */

@Controller
public class UserController {

    private UserService userService;

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    //On Client send request with header Content-Type:application/x-www-form-urlencoded
    //and body firstName=fName&lastName=lName&apartment=app&contactPhoneNumber=654654654654&password=someMyPass

    //This one is used when non admin wants to "join the club" :)
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") User user){
        user.setId(0); //for injection attempts cases
        user.setEnabled(false); //for injection attempts cases
        this.userService.addUser(user);
        return "registerpages/regCompPage";
    }

}
