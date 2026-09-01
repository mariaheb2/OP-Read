package org.opread.domain.exception;

public class ResourceNotFoundException extends DomainException {

    public ResourceNotFoundException(String resourceName, Object identifier) {
        super(resourceName + " não encontrado com o identificador: " + identifier);
    }
}