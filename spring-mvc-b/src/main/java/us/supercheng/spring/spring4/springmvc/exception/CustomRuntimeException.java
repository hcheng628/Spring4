package us.supercheng.spring.spring4.springmvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "You are bad and so does your request!")
public class CustomRuntimeException extends RuntimeException {

}