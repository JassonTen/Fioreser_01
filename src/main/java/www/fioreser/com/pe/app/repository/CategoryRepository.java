package www.fioreser.com.pe.app.repository;

import www.fioreser.com.pe.infrastructure.entity.CategoryEntity;

/**
 *
 * @author FENIX
 */
public interface CategoryRepository {
    Iterable<CategoryEntity> getCategory();
    CategoryEntity getCategoryById(Integer idCa);
    CategoryEntity guardarCategory(CategoryEntity categoryEntity);
    boolean deleteCategoryById(Integer idCa);
}
