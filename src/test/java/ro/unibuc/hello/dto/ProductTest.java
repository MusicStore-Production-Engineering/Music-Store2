package ro.unibuc.hello.dto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    public void testProductGettersAndSetters() {
  
        Product product = new Product();
        product.setId(1L);
        product.setProductName("Product1");
        product.setDescription("Description1");
        product.setCategories("Category1");

        long id = product.getId();
        String productName = product.getProductName();
        String description = product.getDescription();
        String categories = product.getCategories();

        // Assert
        Assertions.assertEquals(1L, id);
        Assertions.assertEquals("Product1", productName);
        Assertions.assertEquals("Description1", description);
        Assertions.assertEquals("Category1", categories);
    }

    @Test
    public void testProductConstructor() {

        long id = 1L;
        String productName = "Product1";
        String description = "Description1";
        String categories = "Category1";

        Product product = new Product(id, productName, description, categories);

        // Assert
        Assertions.assertEquals(id, product.getId());
        Assertions.assertEquals(productName, product.getProductName());
        Assertions.assertEquals(description, product.getDescription());
        Assertions.assertEquals(categories, product.getCategories());
    }


}