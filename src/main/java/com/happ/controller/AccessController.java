package com.happ.controller;

import com.happ.AccessPointsEnum;
import com.happ.model.AccessPoints;
import com.happ.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ievgenii.tsybaiev on 09.01.2017.
 */

@Controller
public class AccessController {

    private RaspberryControllerService raspberryControllerService;
    private AccessPointsService accessPointsService;

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

    @RequestMapping("/controller/open/{id}")
    @PreAuthorize("isAuthenticated()")
    public void openAccessPoint(@PathVariable("id") int id){
        AccessPoints accessPoint = accessPointsService.getAccessPointById(id);
        System.out.println("Opening access point " + accessPoint);
        raspberryControllerService.openAccessPoint(AccessPointsEnum.getAccessPointEnumByName(accessPoint.getAccessPointName()));
    }
}
