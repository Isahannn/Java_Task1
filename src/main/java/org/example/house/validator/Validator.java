package org.example.house.validator;

import org.apache.logging.log4j.Logger;
import java.util.function.Predicate;

public interface Validator<T> {
    boolean validate(T object);

    default <V> boolean validateField(V value, Predicate<V> validator,
                                      String errorMessage, Logger logger) {
        boolean isValid = validator.test(value);
        if (!isValid) {
            logger.error(errorMessage, value);
        }
        return isValid;
    }
}