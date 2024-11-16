package www.fioreser.com.pe.app.service;

import java.util.List;
import www.fioreser.com.pe.app.repository.StockRepository;
import www.fioreser.com.pe.infrastructure.entity.ProductEntity;
import www.fioreser.com.pe.infrastructure.entity.StockEntity;

/**
 *
 * @author FENIX
 */
public class StockService {
    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }
   public StockEntity guardarStock(StockEntity stockEntity){
       return stockRepository.guardarStock(stockEntity);
   }
   public List<StockEntity> getStockByProductEntity(ProductEntity productEntity){
     return stockRepository.getStockByProductEntity(productEntity);
   }
}
