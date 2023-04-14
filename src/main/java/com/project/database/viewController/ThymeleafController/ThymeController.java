package com.project.database.viewController.ThymeleafController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("thyme")
public class ThymeController {
    @GetMapping("/hellothyme")
    public String sayHelloThyme(HttpServletRequest request,HttpServletResponse reqResponse,Model model) {
        model.addAttribute("msg", "Mr Phương");
        return "hello.html";
    }
}
