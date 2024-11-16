package www.fioreser.com.pe.infrastructure.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import www.fioreser.com.pe.app.service.StockService;
import www.fioreser.com.pe.app.service.ValidarStock;
import www.fioreser.com.pe.infrastructure.entity.ProductEntity;
import www.fioreser.com.pe.infrastructure.entity.StockEntity;

/**
 *
 * @author FENIX
 */
@Controller
@RequestMapping("/admin/products/stock")
public class StockController {
    private final StockService stockService; 
    private final ValidarStock validarStock;

    public StockController(StockService stockService, ValidarStock validarStock) {
        this.stockService = stockService;
        this.validarStock = validarStock;
    }
    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model){
        ProductEntity product = new ProductEntity();
        product.setIdPr(id);
        List<StockEntity> stocks = stockService.getStockByProductEntity(product);
        model.addAttribute("stocks", stocks); 
        model.addAttribute("idproduct", id); 
        return "admin/stock/show";
    }
    
    @GetMapping("create-unit-product/{id}")
    public String create(@PathVariable Integer id, Model model){
        model.addAttribute("idproduct", id );
        return "admin/stock/create";
    }
    
    @PostMapping("save-unit-product")
    public String save(StockEntity stock, @RequestParam("idproduct") Integer idproduct){
        ProductEntity product = new ProductEntity();
        product.setIdPr(idproduct);
        stock.setProductEntity(product);
        stockService.guardarStock(validarStock.calculateBalance(stock));
        return "redirect:/admin";
    }
}
