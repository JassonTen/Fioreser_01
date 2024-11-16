package www.fioreser.com.pe.infrastructure.adapter;

import java.util.List;
import org.springframework.stereotype.Repository;
import www.fioreser.com.pe.app.repository.StockRepository;
import www.fioreser.com.pe.infrastructure.entity.ProductEntity;
import www.fioreser.com.pe.infrastructure.entity.StockEntity;

/**
 *
 * @author FENIX
 */
@Repository
public class StockRepositoryImpl implements StockRepository{
    
    private final StockCrudRepository stockCrudRepository;

    public StockRepositoryImpl(StockCrudRepository stockCrudRepository) {
        this.stockCrudRepository = stockCrudRepository;
    }

    @Override
    public StockEntity saveStock(StockEntity stockEntity) {
        return stockCrudRepository.save(stockEntity);
    }

    @Override
    public List<StockEntity> getStockByProductEntity(ProductEntity productEntity) {
        return stockCrudRepository.getStockByProductEntity(productEntity);
    }
    
    
    
}
