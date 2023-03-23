package ro.unibuc.hello.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ro.unibuc.hello.dto.Product;
import ro.unibuc.hello.exception.EntityNotFoundException;
import ro.unibuc.hello.service.ProductService;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void test_saveProduct() throws Exception {
        // Arrange
        Product product = new Product(1, "AirPods", "AirPods combine intelligent design with breakthrough technology and crystal clear sound.", "Electronics");

        when(productService.saveProduct(any())).thenReturn(product);

        // Act
        MvcResult result = mockMvc.perform(post("/products")
                .content(objectMapper.writeValueAsString(product))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // Assert
        Assertions.assertEquals(result.getResponse().getContentAsString(), objectMapper.writeValueAsString(product));
    }

    @Test
    void test_getProduct() throws Exception {
        // Arrange
        Product product = new Product(1, "AirPods", "AirPods combine intelligent design with breakthrough technology and crystal clear sound.", "Electronics");

        when(productService.getProduct(any())).thenReturn(product);

        // Act
        MvcResult result = mockMvc.perform(get("/product?productName=AirPods")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // Assert
        Assertions.assertEquals(result.getResponse().getContentAsString(), objectMapper.writeValueAsString(product));
    }

    @Test
    void test_getProduct_cascadesException() {
        // Arrange
        String productName = "AirPods";
        when(productService.getProduct(any())).thenThrow(new EntityNotFoundException(productName));

        // Act
        EntityNotFoundException exception = assertThrows(
                EntityNotFoundException.class,
                () -> productController.info(productName),
                "Expected getProduct() to throw EntityNotFoundException, but it didn't");

        // Assert
        assertTrue(exception.getMessage().contains(productName));
    }
}