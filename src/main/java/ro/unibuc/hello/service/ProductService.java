package ro.unibuc.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ro.unibuc.hello.data.ProductEntity;
import ro.unibuc.hello.data.ProductRepository;
import ro.unibuc.hello.exception.EntityNotFoundException;
import ro.unibuc.hello.dto.ProductDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    
    // public Product saveProduct(Product product)
    // {
    //     ProductEntity productEntity = new ProductEntity(
    //     );
        
    //     productEntity.categories = product.getCategories();
    //     productEntity.description = product.getDescription();

    //     productRepository.save(productEntity);
    //     return product;
    // }
 
   // public ProductDTO getProduct(String title) {
        // ProductEntity entity = productRepository.findByTitle(title);
        // Product product = new Product(
        // );
        // product.setProductName(entity.productName);
        // product.setCategories(entity.categories);
        // product.setDescription(entity.description);
        // return product;

        // return entity.get<>;
  
       
            // ProductEntity productEntity = new ProductEntity();
            // productEntity.productName = productDTO.productName;
            // productEntity.description = productDTO.description;
            // productEntity.categories = productDTO.categories;
            // return productRepository.save(productEntity);
        

    //}

    public List<ProductEntity> getProducts()
    {
        
        
        return productRepository.findAll();
    }
    public ProductEntity createProduct(ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.productName = productDTO.productName;
        productEntity.description = productDTO.description;
        productEntity.categories = productDTO.categories;
        return productRepository.save(productEntity);
    } 
    public ProductDTO getProductByName(String productName) {
        ProductEntity productEntity = productRepository.findByProductName(productName);
        if (productEntity != null) {
            ProductDTO productDto = new ProductDTO();
          
            productDto.productName = productEntity.productName;
            productDto.description = productEntity.description;
            productDto.categories = productEntity.categories;
            return productDto;
        } else {
            return null;
        }
    }
    public List<ProductDTO> getAllProducts() {
        List<ProductEntity> productEntities = productRepository.findAll();
        List<ProductDTO> productDtos = new ArrayList<>();
        for (ProductEntity productEntity : productEntities) {
            ProductDTO productDto = new ProductDTO();
            productDto.productName = productEntity.productName;
            productDto.description = productEntity.description;
            productDto.categories = productEntity.categories;
            productDtos.add(productDto);
        }
        return productDtos;
    }

    public void deleteProductById(String id) {
        productRepository.deleteById(id);
    }

}
