package com.CookieMomsterDFW.Main.services.implementations;

import com.CookieMomsterDFW.Main.dao.ProductRepository;
import com.CookieMomsterDFW.Main.dto.ProductDto;
import com.CookieMomsterDFW.Main.models.ProductModel;
import com.CookieMomsterDFW.Main.services.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {

        ProductModel newProduct = new ProductModel();
        BeanUtils.copyProperties(productDto, newProduct);

        ProductModel storedProduct = productRepository.save(newProduct);
        ProductDto returnValue = new ProductDto();
        BeanUtils.copyProperties(storedProduct, returnValue);
        return returnValue;
    }

    @Override
    public List<ProductDto> getProducts(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<ProductModel> products = productRepository.findAll(paging);
        List<ProductDto> returnValue = new ArrayList<>();
        for (ProductModel product : products) {
            ProductDto temp = new ProductDto();
            BeanUtils.copyProperties(product, temp);
            returnValue.add(temp);
        }
        return returnValue;
    }
}
