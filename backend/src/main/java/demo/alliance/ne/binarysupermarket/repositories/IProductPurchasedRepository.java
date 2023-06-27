package demo.alliance.ne.binarysupermarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import demo.alliance.ne.binarysupermarket.models.ProductPurchased;
import demo.alliance.ne.binarysupermarket.models.User;

import java.util.List;
import java.util.UUID;

public interface IProductPurchasedRepository extends JpaRepository<ProductPurchased, UUID> {
    List<ProductPurchased> findByCustomer(User customer);
}
