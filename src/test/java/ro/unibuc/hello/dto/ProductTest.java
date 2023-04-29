package ro.unibuc.hello.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ro.unibuc.hello.dto.Product;

class ProductTest {

    Product test = new Product("Ibanez abc123", "test description", "Guitar");



    @Test
    void test_name(){
        Assertions.assertEquals("Ibanez abc123", test.getName());
    }

    @Test
    void test_description(){
        Assertions.assertEquals("test description", test.getDescription());
    }

    @Test
    void test_categories(){
        Assertions.assertEquals("Guitar", test.getCategories());
    }

    @Test
    void test_set_name() {
        String testName = "test_name";
        test.setName(testName);
        Assertions.assertEquals(testName, test.getName());
    }
    @Test
    void test_set_description() {
        String testDescription = "test_description";
        test.setDescription(testDescription);
        Assertions.assertEquals(testDescription, test.getDescription());
    }
    @Test
    void test_set_categories() {
        String testCategories = "test_categories";
        test.setCategories(testCategories);
        Assertions.assertEquals(testCategories, test.getCategories());
    }
}