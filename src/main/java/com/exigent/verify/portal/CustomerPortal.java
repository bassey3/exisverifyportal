package com.exigent.verify.portal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerPortal{

    @GetMapping("/admin/dashboard")
    public String adminDash(@AuthenticationPrincipal OidcUser user) {
        return "Hello, " + user.getFullName();
    }

    @GetMapping("/customer/")
    public String customerDash(@AuthenticationPrincipal OidcUser user, HttpSession session) {
        if(user != null){
            return "Hello, " + user.getFullName();
        }
        HttpServletRequest request;
        session.setAttribute("name", "lawrence");
        return "customer/dashboard";
    }
}
