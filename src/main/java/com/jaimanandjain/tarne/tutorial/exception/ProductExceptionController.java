/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.jaimanandjain.tarne.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author rahul.jaiman
 * @version $Id: ProductExceptionController.java, v 0.1 2020-05-14 19:16 rahul.jaiman Exp $$
 */

@ControllerAdvice
public class ProductExceptionController {

    @ExceptionHandler(value =  ProductNotFoundException.class)
    public ResponseEntity<Object> exception(ProductNotFoundException exception){
        return new ResponseEntity<>("ProductNotFound Exception", HttpStatus.NOT_FOUND);
    }
}