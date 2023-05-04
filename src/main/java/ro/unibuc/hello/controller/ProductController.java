package ro.unibuc.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;

import ro.unibuc.hello.data.ProductEntity;
import ro.unibuc.hello.dto.Product;
import ro.unibuc.hello.exception.EntityNotFoundException;
import ro.unibuc.hello.service.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.concurrent.atomic.AtomicLong;

import java.util.List;


@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    MeterRegistry metricsRegistry;

@PostMapping(path = "/product")
public ResponseEntity<ProductEntity> createProduct(@RequestBody Product productDTO) {
    ProductEntity newProduct = productService.saveProduct(productDTO);
    return ResponseEntity.ok(newProduct);
}

@GetMapping("/products")
@ResponseBody
@Timed(value = "products.time", description = "Time taken to return products")

public List<ProductEntity> getAllProducts() {
        return productService.getAllProducts();
    }
    
}
