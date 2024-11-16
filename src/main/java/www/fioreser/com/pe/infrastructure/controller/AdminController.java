package www.fioreser.com.pe.infrastructure.controller;

import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import www.fioreser.com.pe.app.service.ProductService;
import www.fioreser.com.pe.infrastructure.entity.ProductEntity;

/**
 *
 * @author FENIX
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    
    private final ProductService productService;
    
    public AdminController(ProductService productService){
        this.productService = productService;
    }
    
    @GetMapping
    public String menu(){
        
        return "admin/menu";
    }
    
}
