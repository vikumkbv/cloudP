package com.giga.FashionStore.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * route controller for default requests.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class DefaultController implements ErrorController {

    @RequestMapping("/error")
    public String error(Model model) {
        return "welcome";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
