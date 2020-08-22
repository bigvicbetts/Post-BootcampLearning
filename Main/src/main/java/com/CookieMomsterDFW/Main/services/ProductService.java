package com.CookieMomsterDFW.Main.services;

import com.CookieMomsterDFW.Main.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);

    List<ProductDto> getProducts(Integer pageNo, Integer pageSize, String sortBy);
}
