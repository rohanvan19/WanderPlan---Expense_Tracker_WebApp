
package com.wanderplan.wanderplan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Map root URL "/" and "/index" to the index.html Thymeleaf template
    @GetMapping({"/"})
    public String index() {
        return "index";  // This resolves to src/main/resources/templates/index.html
    }

}
