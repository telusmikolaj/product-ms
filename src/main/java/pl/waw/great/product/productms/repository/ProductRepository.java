package pl.waw.great.product.productms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.waw.great.product.productms.domain.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, Long> {
    Optional<Product> findProductByTitle(String title);

    boolean existsProductsByTitle(String title);

    Optional<Product> findProductById(Long id);

    List<Product> findProductsByCategory(String category);

    long deleteProductById(Long id);
}
