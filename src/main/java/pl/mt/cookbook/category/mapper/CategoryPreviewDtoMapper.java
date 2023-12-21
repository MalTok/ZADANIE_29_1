package pl.mt.cookbook.category.mapper;

import org.springframework.stereotype.Service;
import pl.mt.cookbook.category.Category;
import pl.mt.cookbook.category.dto.CategoryPreviewDto;
import pl.mt.cookbook.recipe.Recipe;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryPreviewDtoMapper {
    public CategoryPreviewDto mapToPreviewDto(Category category) {
        CategoryPreviewDto categoryPreviewDto = new CategoryPreviewDto();
        categoryPreviewDto.setName(category.getName());
        categoryPreviewDto.setDescription(category.getDescription());
        categoryPreviewDto.setImg(category.getImg());
        List<Long> recipeIds = new ArrayList<>();
        for (Recipe recipe : category.getRecipes()) {
            Long id = recipe.getId();
            recipeIds.add(id);
        }
        categoryPreviewDto.setRecipeIds(recipeIds);
        return categoryPreviewDto;
    }
}
