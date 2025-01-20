package kiosk.exception;


// 예외 처리
public class InvalidMenuException extends RuntimeException{
    public InvalidMenuException(String message){
        super(message);
    }
}
