package www.fioreser.com.pe.infrastructure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import www.fioreser.com.pe.app.service.CategoryService;
import www.fioreser.com.pe.infrastructure.entity.CategoryEntity;

/**
 *
 * @author FENIX
 */
@Controller
@RequestMapping("/admin/category")
public class CategoryController {
  private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/show")
    public String showCategoryList(Model model) {
        model.addAttribute("category", categoryService.getCategory());
        return "admin/category/show";
    }

    @GetMapping("/create")
    public String createCategoryForm(Model model) {
        model.addAttribute("category", new CategoryEntity());
        return "admin/category/create";
    }

    @PostMapping("/save")
    public String saveCategoryL(@ModelAttribute("category") CategoryEntity categoryEntity) {
        categoryService.saveCategory(categoryEntity);
        return "redirect:/admin/category/show";
    }

    @GetMapping("/edit/{idtf}")
    public String editCategoryForm(@PathVariable("idCa") Integer idCa, Model model) {
        CategoryEntity category = categoryService.getCategoryById(idCa);
        model.addAttribute("category", category);
        return "admin/category/edit";
    }

    @PostMapping("/update")
    public String updateCategoryL(@ModelAttribute("category") CategoryEntity categoryEntity) {
        categoryService.saveCategory(categoryEntity);
        return "redirect:/admin/category/show";
    }

    @GetMapping("/delete/{idCa}")
    public String deleteCategoryL(@PathVariable("idCa") Integer idCa) {
        categoryService.deleteCategoryById(idCa);
        return "redirect:/admin/category/show";
    }    
}
