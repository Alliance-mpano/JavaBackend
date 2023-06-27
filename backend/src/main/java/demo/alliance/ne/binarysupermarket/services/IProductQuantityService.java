package demo.alliance.ne.binarysupermarket.services;

import demo.alliance.ne.binarysupermarket.dtos.NewProductQuantityDTO;
import demo.alliance.ne.binarysupermarket.models.ProductQuantity;

public interface IProductQuantityService {

    Integer byProduct(String productCode);

    ProductQuantity newQuantity(NewProductQuantityDTO dto);
}
