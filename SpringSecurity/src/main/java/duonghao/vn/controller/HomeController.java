package duonghao.vn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import duonghao.vn.service.UserService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";  // Thymeleaf template
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/register")
    public String registerForm() {
        return "register";  // Trả về register.html
    }
    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password, @RequestParam String role) {
        userService.saveUser(username, password, role);  // e.g., role="ROLE_ADMIN"
        return "redirect:/login";
    }

    @GetMapping("/home")
    @PreAuthorize("isAuthenticated()")
    public String home() {
        return "home";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin() {
        return "admin";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String user() {
        return "user";
    }
}