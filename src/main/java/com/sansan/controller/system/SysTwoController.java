package com.sansan.controller.system;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 第一个系统
 */
@RestController
@RequestMapping("/systwo")
public class SysTwoController {

    @RequestMapping("/loginone")
    public ModelAndView loginone(){
        return new ModelAndView("logintwo");
    }
}
