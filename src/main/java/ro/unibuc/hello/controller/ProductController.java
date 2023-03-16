package ro.unibuc.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import ro.unibuc.hello.dto.Product;
import ro.unibuc.hello.exception.EntityNotFoundException;
import ro.unibuc.hello.service.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


@Controller
public class ProductController {

    

    @Autowired
    private ProductService productService;

    // @GetMapping("/product")
    // @ResponseBody
    // public Product info(@RequestParam(name="title", required=false, defaultValue="Overview") String title) throws EntityNotFoundException {
    //     return productService.buildGreetingFromInfo(title);
    // }

    @PostMapping("/products")
    @ResponseBody
    public ResponseEntity<Product> saveProduct(@RequestBody Product product)
    {
        productService.saveProduct(product);
        return ResponseEntity.ok().body(product);
    }
    @GetMapping("/product")
    @ResponseBody
    public Product info(@RequestParam(name="productName", required=false, defaultValue="Overview") String productName) throws EntityNotFoundException {
        return productService.getProduct(productName);
    }
    
 
    
}
