package com.sansan.controller.drivers;

import com.sansan.common.Response;
import com.sansan.service.drivers.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/driver")
public class DriverController {

//
    private  static  final Logger LOGGER = Logger.getLogger("DriverController.class");

    @Autowired
    private DriverService driverService;
    @RequestMapping(value = "/driversList", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    public Response getDriversList(){
        return new Response().success(driverService.getDriverList());
    }
}
