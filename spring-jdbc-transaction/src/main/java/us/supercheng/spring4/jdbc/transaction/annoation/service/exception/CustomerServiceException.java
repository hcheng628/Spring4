package us.supercheng.spring4.jdbc.transaction.annoation.service.exception;

public class CustomerServiceException extends RuntimeException {

    public CustomerServiceException() {
    }

    public CustomerServiceException(String message) {
        super(message);
    }

    public CustomerServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerServiceException(Throwable cause) {
        super(cause);
    }
}
