package pl.waw.great.product.productms.exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Locale;

@ControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(value = {ProductWithGivenIdNotExistsException.class})
    public ResponseEntity<Object> handleProductWithGivenIdNotExistsExceptions(ProductWithGivenIdNotExistsException e) {
        String errorMessage = messageSource.getMessage("productWithGivenIdNotExists", new Object[]{e.getId()}, Locale.getDefault());
        ErrorInfo employeeException = new ErrorInfo(errorMessage, HttpStatus.CONFLICT, LocalDateTime.now());
        log.error(errorMessage);
        return new ResponseEntity<>(employeeException, employeeException.getHttpStatus());
    }

    @ExceptionHandler(value = {ProductWithGivenTitleExists.class})
    public ResponseEntity<Object> handleProductWithGivenTitleExists(ProductWithGivenTitleExists e) {
        String errorMessage = messageSource.getMessage("productWithGivenTitleExists", new Object[]{e.getTitle()}, Locale.getDefault());
        ErrorInfo employeeException = new ErrorInfo(errorMessage, HttpStatus.CONFLICT, LocalDateTime.now());
        log.error(errorMessage);
        return new ResponseEntity<>(employeeException, employeeException.getHttpStatus());
    }

    @ExceptionHandler(value = {ProductWithGivenTitleNotExistsException.class})
    public ResponseEntity<Object> handleProductWithGivenTitleNotExists(ProductWithGivenTitleNotExistsException e) {
        String errorMessage = messageSource.getMessage("productWithGivenTitleNotExists", new Object[]{e.getTitle()}, Locale.getDefault());
        ErrorInfo employeeException = new ErrorInfo(errorMessage, HttpStatus.CONFLICT, LocalDateTime.now());
        log.error(errorMessage);
        return new ResponseEntity<>(employeeException, employeeException.getHttpStatus());
    }

}
