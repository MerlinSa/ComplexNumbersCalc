package logger;


/**
 * Интерфейс Logger определяет метод для логирования сообщений.
 */
public interface ILogger {
    /**
     * Записывает логовое сообщение.
     *
     * @param message Логовое сообщение.
     */
    void log(String message);
}

