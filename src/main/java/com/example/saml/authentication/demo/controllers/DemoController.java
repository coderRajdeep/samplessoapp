package com.example.saml.authentication.demo.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.saml2.provider.service.authentication.Saml2AuthenticatedPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String login() {
        return "login";
    }
    @GetMapping("/home")
    public String home(@AuthenticationPrincipal Saml2AuthenticatedPrincipal principal, Model model) {
        model.addAttribute("firstName", principal.getAttribute("http://wso2.org/claims/givenname").get(0));
        model.addAttribute("lastName", principal.getAttribute("http://wso2.org/claims/lastname").get(0));
        model.addAttribute("userName", principal.getAttribute("http://wso2.org/claims/userid").get(0));
        model.addAttribute("emailaddress", principal.getAttribute("http://wso2.org/claims/emailaddress").get(0));
        model.addAttribute("country", principal.getAttribute("http://wso2.org/claims/country").get(0));
        return "home";
    }
}
