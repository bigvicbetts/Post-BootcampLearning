package com.CookieMomsterDFW.Main.controllers;

import com.CookieMomsterDFW.Main.dto.ProductDto;
import com.CookieMomsterDFW.Main.models.requests.ProductRequest;
import com.CookieMomsterDFW.Main.models.responses.ProductResponse;
import com.CookieMomsterDFW.Main.services.ProductService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {

        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(productRequest, productDto);

        ProductDto updatedProduct = productService.createProduct(productDto);

        ProductResponse returnValue = new ProductResponse();
        BeanUtils.copyProperties(updatedProduct, returnValue);
        return returnValue;
    }

    @GetMapping
    public List<ProductResponse> getProducts(@RequestParam(defaultValue = "0") Integer pageNo,
                                       @RequestParam(defaultValue = "15") Integer pageSize,
                                       @RequestParam(defaultValue = "id") String sortBy) {
        List<ProductResponse> returnValue = new ArrayList<>();
        List<ProductDto> productDtos = productService.getProducts(pageNo, pageSize, sortBy);
        for (ProductDto productDto : productDtos) {
            ProductResponse temp = new ProductResponse();
            BeanUtils.copyProperties(productDto, temp);
            returnValue.add(temp);
        }
        return returnValue;
    }
}
