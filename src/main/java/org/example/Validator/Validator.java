package org.example.Validator;

public interface Validator<T> {
    boolean validate(T object); // Метод для проверки объекта
}