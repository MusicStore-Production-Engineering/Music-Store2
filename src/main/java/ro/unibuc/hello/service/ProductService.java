package ro.unibuc.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ro.unibuc.hello.data.ProductEntity;
import ro.unibuc.hello.data.ProductRepository;
import ro.unibuc.hello.exception.EntityNotFoundException;
import ro.unibuc.hello.dto.Product;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductService() { }
    private final AtomicLong counter = new AtomicLong();

    
    public ProductEntity saveProduct(Product product)
    {
        ProductEntity productEntity = new ProductEntity();


        productEntity.setName(product.getName());
        productEntity.setDescription(product.getDescription());
        productEntity.setCategories(product.getCategories());

        productRepository.save(productEntity);
        return productEntity;
    }
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }
    

}
