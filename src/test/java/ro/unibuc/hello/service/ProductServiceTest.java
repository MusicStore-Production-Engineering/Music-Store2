package ro.unibuc.hello.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ro.unibuc.hello.data.ProductEntity;
import ro.unibuc.hello.data.ProductRepository;
import ro.unibuc.hello.dto.Product;
import ro.unibuc.hello.exception.EntityNotFoundException;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class ProductServiceTest {

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
        Product returnedProduct = productService.saveProduct(test);

        // Assert
        Assertions.assertEquals(1, returnedProduct.getId());
        Assertions.assertEquals(name, returnedProduct.getName());
        Assertions.assertEquals(description, returnedProduct.getDescription());
        Assertions.assertEquals(categories, returnedProduct.getCategories());
    }

}