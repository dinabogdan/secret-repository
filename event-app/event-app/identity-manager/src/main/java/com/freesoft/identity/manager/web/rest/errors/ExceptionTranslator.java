package com.freesoft.identity.manager.web.rest.errors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.NativeWebRequest;
import org.zalando.problem.Problem;
import org.zalando.problem.spring.web.advice.ProblemHandling;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionTranslator implements ProblemHandling {

    @Autowired
    private MessageSource messageSource;

    @Override
    public ResponseEntity<Problem> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, @Nonnull NativeWebRequest request) {
        Problem problem = Problem.builder()
                .withTitle("Method argument not valid")
                .withStatus(defaultConstraintViolationStatus())
                .with("message", ErrorConstants.ERR_VALIDATION)
                .with("fieldErrors", mapFieldErrors(ex))
                .build();

        return create(ex, problem, request);
    }

    private List<FieldError> mapFieldErrors(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors()
                .stream()
                .map(field -> FieldError.builder()
                        .objectName(field.getObjectName())
                        .field(field.getField())
                        .message(field.getDefaultMessage())
                        .build())
                .collect(Collectors.toList());
    }
}
