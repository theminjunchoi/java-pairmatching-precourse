package pairmatching.util.exception;

public enum FunctionException {
    INVALID_CHOOSE("잘못된 기능입니다.");

    private final String exceptionMessage;
    private static final String ERROR_HEADER = "[ERROR] ";

    FunctionException(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return ERROR_HEADER + this.exceptionMessage;
    }
}

