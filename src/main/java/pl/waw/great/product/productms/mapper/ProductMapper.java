package pl.waw.great.product.productms.mapper;


import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;
import pl.waw.great.product.productms.domain.Product;
import pl.waw.great.product.productms.dto.ProductDto;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    ProductDto productToDto(Product product);
    Product dtoToProduct(ProductDto productDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProductFromDto(ProductDto dto, @MappingTarget Product entity);

}
