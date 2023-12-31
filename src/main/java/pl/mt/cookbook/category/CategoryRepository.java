package pl.mt.cookbook.category;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByUrl(String url);

    Optional<Category> findByNameIgnoreCase(String name);
}