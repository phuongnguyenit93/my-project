package com.project.database.viewController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class helloController {
    @GetMapping("/hellojsp")
    public String sayHelloJSP(Model model) {
        model.addAttribute("msg", "Mr Phương");
        return "hello.jsp";
    }

    @GetMapping("/hellothyme")
    public String sayHelloThyme(Model model) {
        model.addAttribute("msg", "Mr Phương");
        return "hello.html";
    }
}
