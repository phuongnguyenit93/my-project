package com.project.database.viewController.JSPController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jsp")
public class JSPController {
    @GetMapping("/hellojsp")
    public String sayHelloJSP(Model model) {
        model.addAttribute("msg", "Mr Phương");
        return "hello.jsp";
    }


}
