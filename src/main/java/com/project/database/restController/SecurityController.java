package com.project.database.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/access")
public class SecurityController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/user")
    public String getAuthentication() {
        Authentication currentAuth = SecurityContextHolder.getContext().getAuthentication();
        return currentAuth.getName();
    }

    @GetMapping("/login/{username}/{password}")
    public String setAuthentication(@PathVariable String username, @PathVariable String password) {
        try {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username,password);
            Authentication authentication = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return "Success";
        } catch (Exception e) {
            return "Fail";
        }
    }

    @GetMapping("/logout")
    public String unsetAuthentication() {
        try {
            Authentication currentAuth = SecurityContextHolder.getContext().getAuthentication();

            if (currentAuth.getName() != "anonymousUser") {
                SecurityContextHolder.clearContext();
                return "Logout success";
            } else {
                return "No user login to logout";
            }
        } catch (Exception e) {
            return "Fail";
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/test-admin-role")
    public String testAdminRole() {
        return "You have admin role";
    }

    @PostAuthorize("hasRole('ROLE_MOD')")
    @GetMapping("/test-mod-role")
    public String testModRole() {
        return "You have mod role";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/test-user-role")
    public String testUserRole() {
        return "You have user role";
    }
}
