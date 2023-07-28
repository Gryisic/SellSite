package com.example.sitedemo.services;

import com.example.sitedemo.models.Image;
import com.example.sitedemo.models.Product;
import com.example.sitedemo.repositiries.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getProducts(String title) {
        if(title != null)
            return productRepository.findProductByTitle(title);

        return productRepository.findAll();
    }

    public void addProduct(Product product, MultipartFile... files) throws IOException {
        for (int i = 0, filesLength = files.length; i < filesLength; i++) {
            MultipartFile file = files[i];

            if (file.getSize() > 1) {
                Image image = toImageEntity(file);
                product.addImageTo(image);

                if (i == 0)
                    image.setPreviewImage(true);
            }
        }

        log.info("Saving new Product. Title: {}, Author: {}", product.getTitle(), product.getAuthor());

        Product productFromDb = productRepository.save(product);
        productFromDb.setPreviewImageId(productFromDb.getImages().get(0).getId());
        productRepository.save(product);
    }

    public void removeProduct(long id){
        productRepository.deleteById(id);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();

        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());

        return image;
    }
}
