package com.rks.rkspetclinic.controllers;

import com.rks.rkspetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/index", "/index.html"})
    public String owners() {
        return "owners/index";
    }
}
