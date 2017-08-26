package us.supercheng.spring4.jdbc.transaction.annoation.service.exception;

public class BookServiceException extends RuntimeException {

    public BookServiceException() {
        super();
    }

    public BookServiceException(String message) {
        super(message);
    }

    public BookServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookServiceException(Throwable cause) {
        super(cause);
    }
}