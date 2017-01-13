package com.happ.controller;

import com.happ.UserRolesEnum;
import com.happ.model.User;
import com.happ.model.UserRoles;
import com.happ.service.AccessHistoryService;
import com.happ.service.UserRolesService;
import com.happ.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ievgenii.tsybaiev on 09.01.2017.
 */

@Controller
public class AdminUserController {

    private UserService userService;
    private AccessHistoryService accessHistoryService;
    private UserRolesService userRolesService;

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired(required = true)
    @Qualifier(value = "accessHistoryService")
    public void setAccessHistoryService(AccessHistoryService accessHistoryService) {
        this.accessHistoryService = accessHistoryService;
    }

    @Autowired(required = true)
    @Qualifier(value = "userRolesService")
    public void setUserRolesService(UserRolesService userRolesService) {
        this.userRolesService = userRolesService;
    }


    @RequestMapping(value = "admin", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String listUsers(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", this.userService.listUsers());
        model.addAttribute("userRolesList", this.userRolesService.getAllUserRoles());
        return "adminpages/admin";
    }

    @RequestMapping(value = "/admin/adduser", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addUser(@ModelAttribute("user") User user){
        if(user.getId() == 0){
//            UserRoles userRoles = new UserRoles();
//            userRoles.setId(userRolesService.getUserRolesId(UserRolesEnum.ROLE_USER));
//            user.setUserRoles(userRoles);
            System.out.println("Adding new user with params " + user.toString());
            this.userService.addUser(user);
        }else {
            System.out.println("Updating user with params " + user.toString());
            this.userService.updateUser(user);
        }

        return "redirect:/admin";
    }

    @RequestMapping("/admin/removeuser/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String removeUser(@PathVariable("id") int id){
        this.userService.removeUser(id);
        return "redirect:/admin";
    }

    @RequestMapping("/admin/edituser/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String editUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("listUsers", this.userService.listUsers());
        model.addAttribute("userRolesList", this.userRolesService.getAllUserRoles());
        return "adminpages/admin";
    }

    @RequestMapping("/admin/userdata/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String userData(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("accessHistoryList", this.accessHistoryService.getAllUserHistoryByUserId(id));
        return "adminpages/userdata";
    }
}
