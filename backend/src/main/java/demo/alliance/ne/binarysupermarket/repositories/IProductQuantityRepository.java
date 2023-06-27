package demo.alliance.ne.binarysupermarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import demo.alliance.ne.binarysupermarket.models.Product;
import demo.alliance.ne.binarysupermarket.models.ProductQuantity;

import java.util.List;
import java.util.UUID;

public interface IProductQuantityRepository extends JpaRepository<ProductQuantity, UUID> {

    List<ProductQuantity> findByProduct(Product product);
}
