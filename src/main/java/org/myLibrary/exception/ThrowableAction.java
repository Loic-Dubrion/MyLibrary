package org.myLibrary.exception;

@FunctionalInterface
public interface ThrowableAction<T> {

    void run(T t) throws Exception;
}
