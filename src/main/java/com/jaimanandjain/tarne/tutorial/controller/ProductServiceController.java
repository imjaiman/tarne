/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.jaimanandjain.tarne.controller;

import com.jaimanandjain.tarne.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rahul.jaiman
 * @version $Id: ProductServiceController.java, v 0.1 2020-05-12 23:19 rahul.jaiman Exp $$
 */
@RestController
public class ProductServiceController {

    private static Map<String,Product> items = new HashMap<>();
    static int count =1;
    static {
        Product p1 = new Product();
        p1.setId("1");
        p1.setName("Honey");
        items.put(p1.getId(),p1);

        Product p2 = new Product();
        p2.setId("2");
        p2.setName("Colgate");
        items.put(p2.getId(),p2);
    }

    @RequestMapping(value = "/products")
    public ResponseEntity<Object> getProducts(@RequestParam(value = "name", required = false, defaultValue = "honey") String name) {

        return new ResponseEntity<>(items.values(), HttpStatus.ACCEPTED);
    }


    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        items.put(product.getId(),product);
        return new ResponseEntity<>("Product is created successfully",HttpStatus.CREATED);

    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id,@RequestBody Product product) {

        items.remove(id);
        product.setId(id);
        items.put(id,product);
        return new ResponseEntity<>("Your product is updated", HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteProduct (@PathVariable("id") String id){

        if(items.containsKey(id)){
            items.remove(id);
            return new ResponseEntity<>("removed successfully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Unable to delete, product may not be present", HttpStatus.BAD_REQUEST);
        }

    }
}