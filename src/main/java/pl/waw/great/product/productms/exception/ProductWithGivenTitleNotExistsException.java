package pl.waw.great.product.productms.exception;

public class ProductWithGivenTitleNotExistsException extends RuntimeException {

    private final String title;

    public ProductWithGivenTitleNotExistsException(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
