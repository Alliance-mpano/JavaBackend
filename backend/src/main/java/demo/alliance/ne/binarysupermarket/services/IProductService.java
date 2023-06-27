package demo.alliance.ne.binarysupermarket.services;

import demo.alliance.ne.binarysupermarket.dtos.CreateOrUpdateProductDTO;
import demo.alliance.ne.binarysupermarket.models.Product;

import java.util.List;

public interface IProductService {

    Product findByCode(String code);

    List<Product> all();

    Product register(CreateOrUpdateProductDTO dto);
}
