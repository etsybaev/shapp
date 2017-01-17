package com.happ.controller;

import com.happ.AccessPointsEnum;
import com.happ.model.AccessHistory;
import com.happ.model.AccessPoints;
import com.happ.model.User;
import com.happ.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ievgenii.tsybaiev on 09.01.2017.
 */

@Controller
public class AccessController {

    private RaspberryControllerService raspberryControllerService;
    private UserService userService;
    private AccessPointsService accessPointsService;
    private AccessHistoryService accessHistoryService;

    @Autowired(required = true)
    @Qualifier(value = "raspberryControllerService")
    public void setRaspberryControllerService(RaspberryControllerService raspberryControllerService) {
        this.raspberryControllerService = raspberryControllerService;
    }

    @Autowired(required = true)
    @Qualifier(value = "accessPointsService")
    public void setAccessPointsService(AccessPointsService accessPointsService) {
        this.accessPointsService = accessPointsService;
    }

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


    @RequestMapping("/controller/open/{id}")
    @PreAuthorize("isAuthenticated()")
    public void openAccessPoint(@PathVariable("id") int id){
        AccessPoints accessPoint = accessPointsService.getAccessPointById(id);
        System.out.println("Opening access point " + accessPoint);

        //Get current loggedIn user
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //Currently we use "Users.ContactPhoneNumber" row as main identifier
        String userIdentifier = auth.getName();
        User user = userService.getUserByContactPhoneNumber(userIdentifier);
        //Adding accessHistory record to DB
        AccessHistory accessHistory = new AccessHistory();
        accessHistory.setUserId(user.getId());
        accessHistory.setAccessPoints(accessPoint);
        accessHistoryService.addHistoryRecord(accessHistory);

        raspberryControllerService.openAccessPoint(AccessPointsEnum.getAccessPointEnumByName(accessPoint.getAccessPointName()));
    }
}
