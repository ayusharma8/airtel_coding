package coding.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import coding.enums.ErrorCode;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

	Logger logger = LoggerFactory.getLogger(ExceptionHandlerController.class);
	
	@ExceptionHandler(IOException.class)
	public ResponseEntity<String> handleIOException(IOException exception) {
		logger.error("IOException Occured",exception);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorCode.IO_EXCEPTION.getErrorCode()+ ErrorCode.IO_EXCEPTION.getMessage());
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> handleRuntimeException(RuntimeException exception) {
		logger.error("RuntimeException Occured",exception);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorCode.RUNTIME_EXCEPTION.getErrorCode()+ErrorCode.RUNTIME_EXCEPTION.getMessage());

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleRuntimeException(Exception exception) {
		logger.error("Exception Occured",exception);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorCode.EXCEPTION.getErrorCode()+ErrorCode.EXCEPTION.getMessage());

	}
}
