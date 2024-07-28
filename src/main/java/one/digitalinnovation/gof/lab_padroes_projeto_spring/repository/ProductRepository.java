package one.digitalinnovation.gof.lab_padroes_projeto_spring.repository;

import one.digitalinnovation.gof.lab_padroes_projeto_spring.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Product entity.
 * <p>
 * Interface de repositório para a entidade Product.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {}

