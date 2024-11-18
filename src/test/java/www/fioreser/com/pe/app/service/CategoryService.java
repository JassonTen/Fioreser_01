package www.fioreser.com.pe.app.service;

import www.fioreser.com.pe.app.repository.CategoryRepository;
import www.fioreser.com.pe.infrastructure.entity.CategoryEntity;

/**
 *
 * @author FENIX
 */
public class CategoryService {
    
    private final CategoryRepository categoryRepositor;
    
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepositor = categoryRepository;
    }
    
    public Iterable<CategoryEntity>  getCategory(){
        return categoryRepositor.getCategory();
    }
   
    public CategoryEntity getCategoryById(Integer idCa){
        return categoryRepositor.getCategoryById(idCa);
    }
    public CategoryEntity saveCategory(CategoryEntity categoryEntity){
        return categoryRepositor.saveCategory(categoryEntity);
    }
    public boolean deleteCategoryById(Integer idCa){
        return categoryRepositor.deleteCategoryById(idCa);
    }
    
}
