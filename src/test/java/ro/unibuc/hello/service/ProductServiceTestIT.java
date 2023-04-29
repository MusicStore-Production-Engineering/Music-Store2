package ro.unibuc.hello.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ro.unibuc.hello.data.ProductEntity;
import ro.unibuc.hello.data.ProductRepository;
import ro.unibuc.hello.dto.Product;

@SpringBootTest
@Tag("IT")
class ProductServiceTestIT {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    @Test
    void test_saveProduct_returnsProductEntity() {
        // Arrange

        String name = "Product Name Test Save";
        String description = "ProductDescription Test Save";
        String categories = "ProductCategories Test Save";

        Product productDto = new Product(name, description, categories);
        // Act
        ProductEntity project = productService.saveProduct(productDto);

        // Assert
        Assertions.assertEquals(name, project.getName());
        Assertions.assertEquals(description, project.getDescription());
        Assertions.assertEquals(categories, project.getCategories());
    }
}


