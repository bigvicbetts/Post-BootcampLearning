package com.CookieMomsterDFW.Main.dao;

import com.CookieMomsterDFW.Main.models.ProductModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<ProductModel, Long> {
}
