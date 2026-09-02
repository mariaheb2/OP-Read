package org.opread.domain.exception;

public class EmailNotFoundException extends DomainException {
    public EmailNotFoundException(String email) {

        super("O email "+ email + "não foi encontrado");
    }
}
