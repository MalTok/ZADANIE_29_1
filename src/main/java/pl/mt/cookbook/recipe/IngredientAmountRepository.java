package pl.mt.cookbook.recipe;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientAmountRepository extends JpaRepository<IngredientAmount, Long> {
    List<IngredientAmount> findAllByIdIn(List<Long> ids);
}
