package com.example.springdemo.controller;

import com.example.springdemo.entity.Product;
import com.example.springdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/products")
public class ProductApi {
    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getList() {
        return ResponseEntity.ok(productService.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<?> getDetail(@PathVariable String id) {
        Optional<Product> optionalProduct = productService.findById(id);
        if (!optionalProduct.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalProduct.get());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.ok(productService.save(product));
    }

    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public ResponseEntity<Product> update(@PathVariable String id, @RequestBody Product product) {
        Optional<Product> optionalProduct = productService.findById(id);
        if (!optionalProduct.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        Product updateProduct = optionalProduct.get();
        // map object
        updateProduct.setName(product.getName());
        updateProduct.setSlug(product.getSlug());
        updateProduct.setDescription(product.getDescription());
        updateProduct.setDetail(product.getDetail());
        updateProduct.setPrice(product.getPrice());
        updateProduct.setThumbnail(product.getThumbnail());
        updateProduct.setManufacturer(product.getManufacturer());
        return ResponseEntity.ok(productService.save(updateProduct));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        if (!productService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
