package ec.webmarket.restful.common;

public class ApiException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ApiException(String message) {
		super(message);
	}
}
