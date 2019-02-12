package com.freesoft.identity.manager.web.rest.errors;

import lombok.Builder;

import java.io.Serializable;

@Builder
public class FieldError implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String objectName;
    private final String field;
    private final String message;

    public String getObjectName() {
        return objectName;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}
