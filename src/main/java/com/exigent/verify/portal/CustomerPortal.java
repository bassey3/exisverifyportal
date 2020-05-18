package com.exigent.verify.portal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerPortal{

    @GetMapping("/admin/dashboard")
    public String adminDash(@AuthenticationPrincipal OidcUser user) {
        return "Hello, " + user.getFullName();
    }

    @GetMapping("/customer/")
    public String customerDash(@AuthenticationPrincipal OidcUser user, HttpSession session) {
        if(user != null){
            session.setAttribute("name", user.getFullName());
            return "customer/dashboard";
        }
        HttpServletRequest request;
        session.setAttribute("name", "lawrence");
        return "customer/dashboard";
    }
    @RequestMapping("/")
    public String home(@AuthenticationPrincipal OidcUser user, HttpSession session){
        return customerDash(user, session);
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "/login";
    }
}
