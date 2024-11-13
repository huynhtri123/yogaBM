package org.example.yogabusinessmanagementweb.service.Impl;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.yogabusinessmanagementweb.common.mapper.ProductMapper;
import org.example.yogabusinessmanagementweb.dto.request.product.ProductCreationRequest;
import org.example.yogabusinessmanagementweb.dto.response.product.AddProductResponse;
import org.example.yogabusinessmanagementweb.dto.response.product.ProductResponse;
import org.example.yogabusinessmanagementweb.exception.AppException;
import org.example.yogabusinessmanagementweb.exception.ErrorCode;
import org.example.yogabusinessmanagementweb.repositories.ProductRepository;
import org.example.yogabusinessmanagementweb.repositories.SubCategoryRepository;
import org.example.yogabusinessmanagementweb.repositories.TempRepository;
import org.example.yogabusinessmanagementweb.service.ProductService;
import org.example.yogabusinessmanagementweb.common.entities.Product;
import org.example.yogabusinessmanagementweb.common.entities.SubCategory;
import org.example.yogabusinessmanagementweb.common.mapper.Mappers;
import org.example.yogabusinessmanagementweb.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;
    SubCategoryRepository subCategoryRepository;
    TempRepository tempRepository;
    ProductMapper productMapper;
    SubCategoryService subCategoryService;

    @Override
    public Page<Product> getAllProduct(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
    @Override
    public Product getProductById(String id) {
        return productRepository.findProductById(Long.valueOf(id))
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND));
    }
    @Override
    public ProductResponse getById(String id) {
        return productMapper.productToProductResponse((getProductById(id)));
    }
    @Override
    public Page<ProductResponse> searchProducts(String keyword, Pageable pageable) {
        Page<Product> productPage;

        if (keyword == null || keyword.isEmpty()) {
            productPage = productRepository.findAll(pageable); // Lấy tất cả sản phẩm
        } else {
            productPage = productRepository.findByTitleContainingIgnoreCase(keyword, pageable); // Tìm kiếm theo từ khóa
        }

        // Chuyển từ Page<Product> sang Page<ProductResponse>
        List<ProductResponse> productResponses =productMapper.productsToProductResponses(productPage.getContent());

        return new PageImpl<>(productResponses, pageable, productPage.getTotalElements());
    }

    @Override
    public Page<ProductResponse> getAllProductBySubcategory(String id,String keyword, Pageable pageable) {
        SubCategory subCategory =  subCategoryService.getSubCategoryById(id);
        Page<Product> productPage;

        if (keyword == null || keyword.isEmpty()) {
            productPage = productRepository.findBySubCategory(subCategory,pageable); // Lấy tất cả sản phẩm
        } else {
            productPage = productRepository.findByTitleContainingIgnoreCase(keyword, pageable); // Tìm kiếm theo từ khóa
        }

        // Chuyển từ Page<Product> sang Page<ProductResponse>
        List<ProductResponse> productResponses =productMapper.productsToProductResponses(productPage.getContent());

        return new PageImpl<>(productResponses, pageable, productPage.getTotalElements());
    }


    @Override
    public Product addProduct(ProductCreationRequest productCreationRequest)  {
        Product product = productMapper.toProduct(productCreationRequest);
        //xử lý SubCategory
        SubCategory subCategory = subCategoryRepository.findById(productCreationRequest.getSubCategoryId())
                .orElseThrow(() -> new AppException(ErrorCode.SUBCATEGORY_NOT_FOUND));

        product.setSubCategory(subCategory);
        //Lưu product
        return productRepository.save(product);
    }

    @Override
    public boolean delete(String id) {
        try {
            Optional<Product> product = productRepository.findById(Long.valueOf(id));
            if (product.isPresent()) {
                Product productEntity = product.get();
                productRepository.deleteById(productEntity.getId());
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
