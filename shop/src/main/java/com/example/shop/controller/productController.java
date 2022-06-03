package com.example.shop.controller;


import com.example.shop.entity.Product;
import com.example.shop.service.ProductService;
import com.example.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * http://localhost:8080/api/V1/products      |   GET     | return list product
 * http://localhost:8080/api/V1/products      |   POST    | create new product
 * http://localhost:8080/api/V1/products/1    |   DELETE  | remove product
 * http://localhost:8080/api/V1/products/1    |   GET     | find product by id
 * http://localhost:8080/api/V1/products/1    |   PUT     | update product
 */


@RestController
@RequestMapping(path = "api/v1/products")
public class productController {
    //CRUD
    @Autowired
    ProductService productService;
    UserService userService;
//    private ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getList(){
        return ResponseEntity.ok(productService.findAll());
    }
    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<?> findById(@PathVariable String id){
        Optional<Product> optionalProduct = productService.findById(id);
        if(!optionalProduct.isPresent()){
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalProduct.get());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Product> save(@RequestBody Product product){
        return ResponseEntity.ok(productService.save(product));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public ResponseEntity deleteById( @PathVariable String id){
        if (!productService.findById(id).isPresent()){
            ResponseEntity.badRequest().build();
        }
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public ResponseEntity<Product> update(@PathVariable String id, @RequestBody Product updateProduct){
        Optional<Product> optionalProduct = productService.findById(id);
        if(!optionalProduct.isPresent()){
            ResponseEntity.badRequest().build();
        }
        Product existingProduct = optionalProduct.get();
        existingProduct.setName(updateProduct.getName());
        existingProduct.setSlug(updateProduct.getSlug());
        existingProduct.setDescription(updateProduct.getDescription());
        existingProduct.setDetail(updateProduct.getDetail());
        existingProduct.setPrice(updateProduct.getPrice());
        existingProduct.setOrigin(updateProduct.getOrigin());
        existingProduct.setUpdateByUser(updateProduct.getUpdateByUser());
        existingProduct.setStatus(updateProduct.getStatus());
        return ResponseEntity.ok(productService.save(existingProduct));
    }
}
