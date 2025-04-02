package org.example.House.validator;

import org.apache.logging.log4j.Logger;
import java.util.function.Predicate;

public interface Validator<T> {
    boolean validate(T object);

    default <F> boolean validateField(F value, Predicate<F> validator,
                                      String errorMessage, Logger logger) {
        boolean isValid = validator.test(value);
        if (!isValid) {
            logger.error(errorMessage, value);
        }
        return isValid;
    }
}