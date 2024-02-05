package org.example.common.exception_.basic;

// 自定义异常
public class SelfDefinedException extends RuntimeException {
    SelfDefinedException() {
        super();
    }

    public SelfDefinedException(String message) {
        super(message);
    }

    public SelfDefinedException(Throwable cause) {
        super(cause);
    }

    public SelfDefinedException(String message, Throwable cause) {
        super(message, cause);
    }
}



