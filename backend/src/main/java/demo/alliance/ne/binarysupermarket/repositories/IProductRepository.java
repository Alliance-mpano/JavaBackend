package demo.alliance.ne.binarysupermarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import demo.alliance.ne.binarysupermarket.models.Product;

public interface IProductRepository extends JpaRepository<Product,String> {
}
