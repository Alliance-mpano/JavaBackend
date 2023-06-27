package demo.alliance.ne.binarysupermarket.services;

import demo.alliance.ne.binarysupermarket.dtos.PurchaseProductDTO;
import demo.alliance.ne.binarysupermarket.models.ProductPurchased;

import java.util.List;

public interface IProductPurchasedService {

    List<ProductPurchased> byLoggedInCustomer();

    List<ProductPurchased> all();

    ProductPurchased purchase(PurchaseProductDTO dto);
}
