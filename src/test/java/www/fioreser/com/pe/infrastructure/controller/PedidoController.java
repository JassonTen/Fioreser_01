package www.fioreser.com.pe.infrastructure.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import www.fioreser.com.pe.app.domain.ItemCarrito;
import www.fioreser.com.pe.app.service.CarritoService;
import www.fioreser.com.pe.app.service.PedidoProductService;
import www.fioreser.com.pe.app.service.PedidoService;
import www.fioreser.com.pe.app.service.ProductService;
import www.fioreser.com.pe.app.service.StockService;
import www.fioreser.com.pe.app.service.UsuarioService;
import www.fioreser.com.pe.app.service.ValidarStock;
import www.fioreser.com.pe.infrastructure.entity.PedidoEntity;
import www.fioreser.com.pe.infrastructure.entity.PedidoProductEntity;
import www.fioreser.com.pe.infrastructure.entity.StockEntity;
import www.fioreser.com.pe.infrastructure.entity.UsuarioEntity;

/**
 *
 * @author FENIX
 */
@Controller
@RequestMapping("/user/pedido")
public class PedidoController {
     public final CarritoService carritoService;
    public final UsuarioService usuarioService;
    public final ProductService productService;
    public final PedidoService pedidoService;
    public final PedidoProductService pedidoProductService;
    public final StockService stockService;
    public final ValidarStock validarStock;
    
     private final Integer entradas = 0;
     private final Logger log = LoggerFactory.getLogger(PedidoController.class);

    public PedidoController(CarritoService carritoService, UsuarioService usuarioService, ProductService productService, PedidoService pedidoService, PedidoProductService pedidoProductService, StockService stockService, ValidarStock validarStock) {
        this.carritoService = carritoService;
        this.usuarioService = usuarioService;
        this.productService = productService;
        this.pedidoService = pedidoService;
        this.pedidoProductService = pedidoProductService;
        this.stockService = stockService;
        this.validarStock = validarStock;
    }
     
     @GetMapping("/sumary-order")
    public String showSumaryOrder(Model model){
         UsuarioEntity user = usuarioService.findById(1);
        model.addAttribute("cart", carritoService.getItemCarts());
        model.addAttribute("total", carritoService.getTotalCart());
        model.addAttribute("user", user);
       // model.addAttribute("id", httpSession.getAttribute("iduser").toString());
       // model.addAttribute("nombre", httpSession.getAttribute("name").toString());
        return "user/summaryorder";
    }
    @GetMapping("/create-order")
    public String createOrder(RedirectAttributes attributes) {
        UsuarioEntity user = usuarioService.findById(1);
        PedidoEntity order = new PedidoEntity();
        order.setFechaCreada(LocalDateTime.now());
        order.setStatus("Proceso");
        order.setUsuarioEntity(user);
        order.setTotal(carritoService.getTotalCart().toString());
        log.info("order : {}", order);
        
        //guardar Order
        order = pedidoService.createOrder(order);
        
        List<PedidoProductEntity> pedidoProduct = new ArrayList<>();
        for (ItemCarrito itemCart : carritoService.getItemCarts()) {
            pedidoProduct.add(new PedidoProductEntity(productService.getProductById(itemCart.getIdPrC()),itemCart.getCantidad(),order));
        }

        pedidoProduct.forEach(
                op -> {
                    pedidoProductService.createOrder(op);
                    StockEntity stock = new StockEntity();
                    stock.setDescripcion("salida");
                    stock.setIngreso(entradas);
                    stock.setProductEntity(op.getProductEntity());
                    stock.setSalida(op.getCantidad());
                    stockService.saveStock(validarStock.calculateBalance(stock));
                }
        );
        

        carritoService.removeAllItemsCart();
       // attributes.addFlashAttribute("id", httpSession.getAttribute("iduser").toString());
        //attributes.addFlashAttribute("nombre", httpSession.getAttribute("name").toString());
       
       return "redirect:/home";
    }
}
