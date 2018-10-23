package com.sansan.controller.system;

import com.sansan.common.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;

/**
 * 第一个系统
 */
@RestController
@RequestMapping("/sysone")
public class SysOneController {

    @RequestMapping("/loginone")
    public ModelAndView loginone(){
        return new ModelAndView("loginone");
    }
}
