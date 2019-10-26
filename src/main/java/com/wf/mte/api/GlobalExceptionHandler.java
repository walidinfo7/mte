package com.wf.mte.api;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

import com.wf.mte.exception.ApiError;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
	/** Provides handling for exceptions throughout this service. */
	@ExceptionHandler({ ConstraintViolationException.class, MethodArgumentNotValidException.class })
	public final ResponseEntity<ApiError> handleException(Exception ex, WebRequest request) {
		HttpHeaders headers = new HttpHeaders();

		if (ex instanceof MethodArgumentNotValidException) {
			HttpStatus status = HttpStatus.BAD_REQUEST;
			MethodArgumentNotValidException cnae = (MethodArgumentNotValidException) ex;
			return handleMethodArgumentNotValidExceptionn(cnae, headers, status, request);
		}
		if (ex instanceof ConstraintViolationException) {
			HttpStatus status = HttpStatus.BAD_REQUEST;
			ConstraintViolationException cnae = (ConstraintViolationException) ex;
			return handleConstraintViolationException(cnae, headers, status, request);
		}
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		return handleExceptionInternal(ex, null, headers, status, request);
	}
	

	/** Customize the response for ConstraintViolationException. */
	protected ResponseEntity<ApiError> handleConstraintViolationException(ConstraintViolationException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<String> errorMessages = ex.getConstraintViolations().stream()
				.map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
				.collect(Collectors.toList());

		return handleExceptionInternal(ex, new ApiError(status, ex.getMessage(), errorMessages), headers, status,
				request);
	}

	/** Customize the response for MethodArgumentNotValidException. */
	protected ResponseEntity<ApiError> handleMethodArgumentNotValidExceptionn(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return handleExceptionInternal(ex, new ApiError(status, ex.getMessage()), headers, status, request);
	}

	/** A single place to customize the response body of all Exception types. */
	protected ResponseEntity<ApiError> handleExceptionInternal(Exception ex, ApiError body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
			request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
		}

		return new ResponseEntity<>(body, headers, status);
	}
}
