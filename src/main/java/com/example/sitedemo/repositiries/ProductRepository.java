package com.example.sitedemo.repositiries;

import com.example.sitedemo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductByTitle(String title);
}
