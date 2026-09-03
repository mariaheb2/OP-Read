package org.opread.domain.exception;

public class EmailAlreadyExistsException extends DomainException {
    public EmailAlreadyExistsException(String email) {

        super("O email "+ email + "já existe no sistema.");
    }
}
