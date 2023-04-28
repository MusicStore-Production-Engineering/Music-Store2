package ro.unibuc.hello.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ro.unibuc.hello.data.ProductEntity;
import ro.unibuc.hello.data.ProductRepository;
import ro.unibuc.hello.dto.Product;

/*
@ExtendWith(SpringExtension.class)
class ProductServiceTestIt {

    @Mock
    ProductRepository mockProductRepository;

    @InjectMocks
    ProductService productService = new ProductService();

    @Test
    void test_save_returnsProduct(){
        // Arrange
        String name = "Ibanez";
        String description = "Test description";
        String categories = "Guitar";
        Product test = new Product(1, name, description, categories);

        // Act
        ProductEntity returnedProduct = productService.saveProduct(test);

        // Assert
        Assertions.assertEquals(1, returnedProduct.getId());
        Assertions.assertEquals(name, returnedProduct.getName());
        Assertions.assertEquals(description, returnedProduct.getDescription());
        Assertions.assertEquals(categories, returnedProduct.getCategories());
    }

}*/

@SpringBootTest
@Tag("IT")
class ProjectServiceTestIT {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    @Test
    void test_saveProject_returnsProject() {
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
    }
}
