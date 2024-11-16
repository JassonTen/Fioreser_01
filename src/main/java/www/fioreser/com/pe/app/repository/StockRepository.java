package www.fioreser.com.pe.app.repository;

import java.util.List;
import www.fioreser.com.pe.infrastructure.entity.ProductEntity;
import www.fioreser.com.pe.infrastructure.entity.StockEntity;

/**
 *
 * @author FENIX
 */
public interface StockRepository {
    
    StockEntity guardarStock(StockEntity stockEntity);
    List<StockEntity> getStockByProductEntity(ProductEntity productEntity);
    
}
