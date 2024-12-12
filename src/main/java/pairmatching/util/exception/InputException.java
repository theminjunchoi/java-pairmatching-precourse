package pairmatching.util.exception;

public enum InputException {
    INVALID_CHOOSE("잘못된 기능입니다."),
    INVALID_STAGE("과정, 레벨, 미션 중에 잘못된 값이 있습니다"),
    INVALID_YES_OR_NO("잘못된 답변입니다.");

    private final String exceptionMessage;
    private static final String ERROR_HEADER = "[ERROR] ";

    InputException(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return ERROR_HEADER + this.exceptionMessage;
    }
}

