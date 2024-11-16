package www.fioreser.com.pe.infrastructure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import www.fioreser.com.pe.app.service.LoginService;

/**
 *
 * @author FENIX
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }
    @GetMapping
    public String login(){
        return "login";
    }
    
}
