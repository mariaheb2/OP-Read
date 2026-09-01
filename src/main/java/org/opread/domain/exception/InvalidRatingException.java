package org.opread.domain.exception;

public class InvalidRatingException extends DomainException {
    public InvalidRatingException(Integer rating) {
        super("A nota ("+ rating+ ") é inválida. O valor deve ser de 1 a 5.");
    }

}
