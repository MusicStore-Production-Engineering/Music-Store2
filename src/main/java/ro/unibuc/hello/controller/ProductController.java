package ro.unibuc.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ro.unibuc.hello.data.ProductEntity;
import ro.unibuc.hello.dto.Product;
import ro.unibuc.hello.exception.EntityNotFoundException;
import ro.unibuc.hello.service.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;


@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
//
//    @PostMapping("/product")
//    public ResponseEntity<Product> saveProduct(Product product)
//    {
//        productService.saveProduct(product);
//        return ResponseEntity.ok().body(product);
//    }
@PostMapping(path = "/product")
public ResponseEntity<ProductEntity> createProduct(@RequestBody Product productDTO) {
    ProductEntity newProduct = productService.saveProduct(productDTO);
    return ResponseEntity.ok(newProduct);
}

@GetMapping("/products")
@ResponseBody
public List<ProductEntity> getAllProducts() {
        return productService.getAllProducts();
    }
    
}
