package pl.mt.cookbook.category.mapper;

import org.springframework.stereotype.Service;
import pl.mt.cookbook.category.Category;
import pl.mt.cookbook.category.dto.CategoryMenuDto;

@Service
public class CategoryMenuDtoMapper {
    public CategoryMenuDto mapToMenuDto(Category category) {
        CategoryMenuDto categoryMenuDto = new CategoryMenuDto();
        categoryMenuDto.setId(category.getId());
        categoryMenuDto.setName(category.getName());
        categoryMenuDto.setUrl(category.getUrl());
        return categoryMenuDto;
    }
}
