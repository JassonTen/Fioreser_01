package www.fioreser.com.pe.infrastructure.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import www.fioreser.com.pe.app.service.LogoutService;

/**
 *
 * @author FENIX
 */
@Controller
@RequestMapping("/logout")
public class LogoutController {
    
    private final LogoutService logoutService;

    public LogoutController(LogoutService logoutService) {
        this.logoutService = logoutService;
    }
    
     @GetMapping
    public String logout(HttpSession httpSession){
        logoutService.logout(httpSession);
        return "redirect:/home";
    }
    
}
