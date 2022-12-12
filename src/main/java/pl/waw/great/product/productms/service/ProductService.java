package pl.waw.great.product.productms.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.waw.great.product.productms.domain.Product;
import pl.waw.great.product.productms.dto.ProductDto;
import pl.waw.great.product.productms.exception.ProductWithGivenIdNotExistsException;
import pl.waw.great.product.productms.exception.ProductWithGivenTitleExists;
import pl.waw.great.product.productms.exception.ProductWithGivenTitleNotExistsException;
import pl.waw.great.product.productms.mapper.ProductMapper;
import pl.waw.great.product.productms.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    public ProductDto create(ProductDto productDto) {
        checkIfTitleDuplicate(productDto.getTitle());
        Product createdProduct = this.productRepository.insert(productMapper.dtoToProduct(productDto));
        return productMapper.productToDto(createdProduct);
    }

    public ProductDto updateProduct(Long id, ProductDto newProduct) {
        checkIfTitleDuplicate(newProduct.getTitle());
        Product product = this.productRepository.findProductById(id).orElseThrow(() -> new ProductWithGivenIdNotExistsException(id));
        productMapper.updateProductFromDto(newProduct, product);
        productRepository.save(product);

        return productMapper.productToDto(product);
    }

    public ProductDto getProduct(Long id) {
        Product product = this.productRepository.findProductById(id).orElseThrow(() -> new ProductWithGivenIdNotExistsException(id));
        return productMapper.productToDto(product);
    }

    public ProductDto getProductByTitle(String title) {
        Product product = this.productRepository.findProductByTitle(title)
                .orElseThrow(() -> new ProductWithGivenTitleNotExistsException(title));

        return productMapper.productToDto(product);
    }

    public List<ProductDto> getProductsByCategory(String category) {
        List<Product> productList = productRepository.findProductsByCategory(category);

        return productList.stream().map(productMapper::productToDto).collect(Collectors.toList());

    }

    public long deleteProduct(Long id) {
        return productRepository.deleteProductById(id);
    }

    private void checkIfTitleDuplicate(String title) {
        if (this.productRepository.existsProductsByTitle(title)) {
            throw new ProductWithGivenTitleExists(title);
        }
    }

}
