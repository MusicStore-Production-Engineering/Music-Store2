package ro.unibuc.hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

import ro.unibuc.hello.data.ProductEntity;
import ro.unibuc.hello.dto.ProductDTO;
import ro.unibuc.hello.exception.EntityNotFoundException;
import ro.unibuc.hello.service.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@Controller
public class ProductController {

    

    @Autowired
    private ProductService productService;




    @PostMapping("/products")
    public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductDTO productDTO) {
        ProductEntity createdProduct = productService.createProduct(productDTO);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @GetMapping("/products/{productName}")
    public ProductDTO getProductByName(@PathVariable String productName) {
        return productService.getProductByName(productName);
    }
    @GetMapping("/products")
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteProductById(id);
    }

    
 
    
}
