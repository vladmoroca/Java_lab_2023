package Java_lab_2023.lab_8.demo.src.main.java.exceptions_hadler;

public class MyExceptionHandler extends RuntimeException {
    public MyExceptionHandler(String message) {
        super(message);
    }

    public MyExceptionHandler(String message, Throwable cause) {
        super(message, cause);
    }
}
