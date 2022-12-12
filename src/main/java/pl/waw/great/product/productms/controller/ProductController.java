package pl.waw.great.product.productms.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.waw.great.product.productms.dto.ProductDto;
import pl.waw.great.product.productms.service.ProductService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private ProductService productService;

    @PostMapping
    public ProductDto createProduct(@Valid @RequestBody ProductDto productDTO) {
        return this.productService.create(productDTO);
    }

    @PutMapping("/{id}")
    public ProductDto updateProduct(@PathVariable Long id, @Valid @RequestBody ProductDto productDTO) {
        return this.productService.updateProduct(id, productDTO);
    }

    @GetMapping("/{title}")
    public ProductDto getProductByTitle(@PathVariable String title) {
        return this.productService.getProductByTitle(title);
    }

    @DeleteMapping("/{id}")
    public long deleteProductById(@PathVariable Long id) {
        return this.productService.deleteProduct(id);
    }

    @GetMapping("/byCategory/{categoryName}")
    public List<ProductDto> byCategory(@PathVariable String category) {
        return this.productService.getProductsByCategory(category);
    }

}
