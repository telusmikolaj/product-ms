package pl.waw.great.product.productms.exception;

public class ProductWithGivenIdNotExistsException extends RuntimeException {
    private final Long id;

    public ProductWithGivenIdNotExistsException(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
