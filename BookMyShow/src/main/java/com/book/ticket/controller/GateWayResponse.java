package com.book.ticket.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.validation.FieldError;

public class GateWayResponse<T> {
	private Boolean status;
	private HttpStatus httpStatus;
	private String message;
	private T result;
	private List<String> errors;
	private List<FieldError> fieldErrors;

	public GateWayResponse() {
		super();
	}

	public GateWayResponse(boolean status, final HttpStatus httpStatus, final T result) {
		super();
		this.result = result;
		this.status = status;
		this.httpStatus = httpStatus;
	}

	public GateWayResponse(final T result) {
		this.result = result;
		this.status = Boolean.TRUE;
		this.httpStatus = HttpStatus.OK;
	}

	public GateWayResponse(boolean status, final HttpStatus httpStatus, final String message,
			final List<String> errors) {
		super();
		this.status = status;
		this.httpStatus = httpStatus;
		this.message = message;
		this.errors = errors;
	}

	public GateWayResponse(String message, final List<FieldError> fieldErrors) {
		super();
		this.status = Boolean.FALSE;
		this.httpStatus = HttpStatus.BAD_REQUEST;
		this.message = message;
		this.fieldErrors = fieldErrors;
	}

	public GateWayResponse(boolean status, final HttpStatus httpStatus, final String message, final String error) {
		super();
		this.status = status;
		this.httpStatus = httpStatus;
		this.message = message;
		if (!StringUtils.isEmpty(error)) {
			errors = Arrays.asList(error);
		}
	}

	public GateWayResponse(HttpStatus httpStatus, final String message) {
		super();
		this.status = Boolean.FALSE;
		this.httpStatus = httpStatus;
		this.message = message;
	}

	public GateWayResponse(final HttpStatus httpStatus, final T result, String message) {
		super();
		this.status = true;
		this.result = result;
		this.httpStatus = httpStatus;
		this.message = message;
	}

	public GateWayResponse(boolean status, final HttpStatus httpStatus, final List<String> errors) {
		super();
		this.status = status;
		this.httpStatus = httpStatus;
		this.message = errors.toString();
		this.errors = errors;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	/**
	 * @return the status
	 */
	public Boolean getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	/**
	 * @return the fieldErrors
	 */
	public List<FieldError> getFieldErrors() {
		return fieldErrors;
	}

	/**
	 * @param fieldErrors the fieldErrors to set
	 */
	public void setFieldErrors(List<FieldError> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}
}
