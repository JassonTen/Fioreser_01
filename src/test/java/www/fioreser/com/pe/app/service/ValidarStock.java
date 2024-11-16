package www.fioreser.com.pe.app.service;

import java.util.List;
import www.fioreser.com.pe.infrastructure.entity.ProductEntity;
import www.fioreser.com.pe.infrastructure.entity.StockEntity;

/**
 *
 * @author FENIX
 */
public class ValidarStock {
    private final StockService stockService;

    public ValidarStock(StockService stockService) {
        this.stockService = stockService;
    }
    
    //verifica el stock por cada producto
    private boolean existBalance(ProductEntity product){
        List<StockEntity> stockList = stockService.getStockByProductEntity(product);
        return stockList.isEmpty() ? false : true;
    }
    
    //calcula el balance del stock
    public StockEntity calculateBalance(StockEntity stock){
        
        if(stock.getIngreso()!= 0){
            if(existBalance(stock.getProductEntity())){
                List<StockEntity> stockList = stockService.getStockByProductEntity(stock.getProductEntity());
                Integer balance = stockList.get(stockList.size()-1).getBalanceo();
                stock.setBalanceo(balance + stock.getIngreso());
            }else{
                stock.setBalanceo(stock.getIngreso());
            }
            
        }else{
            List<StockEntity> stockList = stockService.getStockByProductEntity(stock.getProductEntity());
                Integer balance = stockList.get(stockList.size()-1).getBalanceo();
                stock.setBalanceo(balance - stock.getSalida());
                    
        }
        
        return stock;
    }
}
