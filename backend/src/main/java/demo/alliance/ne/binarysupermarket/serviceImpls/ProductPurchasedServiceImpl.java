package demo.alliance.ne.binarysupermarket.serviceImpls;

import demo.alliance.ne.binarysupermarket.dtos.NewProductQuantityDTO;
import demo.alliance.ne.binarysupermarket.dtos.PurchaseProductDTO;
import demo.alliance.ne.binarysupermarket.enums.EProductQuantityOperation;
import org.springframework.stereotype.Service;
import demo.alliance.ne.binarysupermarket.models.ProductPurchased;
import demo.alliance.ne.binarysupermarket.models.ProductQuantity;
import demo.alliance.ne.binarysupermarket.models.User;
import demo.alliance.ne.binarysupermarket.repositories.IProductPurchasedRepository;
import demo.alliance.ne.binarysupermarket.services.IProductPurchasedService;
import demo.alliance.ne.binarysupermarket.services.IProductQuantityService;
import demo.alliance.ne.binarysupermarket.services.IUserService;

import java.util.List;

@Service
public class ProductPurchasedServiceImpl implements IProductPurchasedService {

    private final IProductPurchasedRepository repository;

    private final IUserService service;

    private final IProductQuantityService productQuantityService;

    public ProductPurchasedServiceImpl(IProductPurchasedRepository repository, IUserService service, IProductQuantityService productQuantityService) {
        this.repository = repository;
        this.service = service;
        this.productQuantityService = productQuantityService;
    }

    @Override
    public List<ProductPurchased> byLoggedInCustomer() {
        User customer = service.getLoggedInUser();
        return repository.findByCustomer(customer);
    }

    @Override
    public List<ProductPurchased> all() {
        return repository.findAll();
    }

    @Override
    public ProductPurchased purchase(PurchaseProductDTO dto) {
        User customer = service.getLoggedInUser();

        NewProductQuantityDTO newProductQuantityDTO = new NewProductQuantityDTO(dto.getCode(),dto.getQuantity(), EProductQuantityOperation.OUT);

        ProductQuantity productQuantity = productQuantityService.newQuantity(newProductQuantityDTO);

        ProductPurchased productPurchased = new ProductPurchased(productQuantity,customer);

        return repository.save(productPurchased);
    }
}
