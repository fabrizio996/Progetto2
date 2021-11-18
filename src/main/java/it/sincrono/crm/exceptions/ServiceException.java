package it.sincrono.crm.exceptions;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;
	private int code;

	public ServiceException(int code, String message) {
		super(message);
		this.code = code;
	}

	public int getCode() {
		return this.code;
	}
}
