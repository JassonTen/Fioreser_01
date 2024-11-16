package www.fioreser.com.pe.infrastructure.controller;

import jakarta.servlet.http.HttpSession;
import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import www.fioreser.com.pe.app.service.CarritoService;

/**
 *
 * @author FENIX
 */
@Controller
@RequestMapping("user/carrito")
public class CarritoController {
    private final CarritoService carritoService;
    private final Logger log = LoggerFactory.getLogger(CarritoController.class);

    public CarritoController(CarritoService carritoService) {
        this.carritoService = carritoService;
    }

    

    @PostMapping("add-product")
    public String addItemCart(@RequestParam Integer quantity, @RequestParam Integer idProduct, @RequestParam String nameProduct, @RequestParam BigDecimal price){
        carritoService.addItemCart(idProduct, nameProduct, quantity, price);
        showcarrito();
        return "redirect:/home";
    }
    private void showcarrito(){
        carritoService.getItemCarts().forEach(itemCart -> log.info("Item cart{}", itemCart));
    }
    
    @GetMapping("/get-carrito")
    public String getcart(Model model,HttpSession httpSession){
        showcarrito();
        model.addAttribute("cart", carritoService.getItemCarts());
        model.addAttribute("total", carritoService.getTotalCart());
        model.addAttribute("id", httpSession.getAttribute("idUs").toString());
        return "user/carrito/carrito";
    }
    @GetMapping("delete-item-cart/{id}")
    public String deleteItemCart(@PathVariable Integer id){
        carritoService.removeItemCart(id);
        return "/redirect:/user/carrito/get-carrito";
    }
    
}
