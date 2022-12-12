package pl.waw.great.product.productms.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


@Builder
@AllArgsConstructor
@Getter
@Setter
public class ErrorInfo {

    private final String message;
    private final HttpStatus httpStatus;
    private final LocalDateTime timestamp;

}
