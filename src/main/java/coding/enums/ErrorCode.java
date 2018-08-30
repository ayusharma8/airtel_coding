package coding.enums;

public enum ErrorCode {

	IO_EXCEPTION("E_1000", "IO Exception Occurred"),
	
	RUNTIME_EXCEPTION("E_2000", "Runtime Exception Occurred"),
	
	EXCEPTION("E_3000", "Exception Occurred");
	
	private String message;
	private String errorCode;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		errorCode = errorCode;
	}
	private ErrorCode(String errorcode, String message) {
		this.message = message;
		this.errorCode = errorCode;
	}
	
}
