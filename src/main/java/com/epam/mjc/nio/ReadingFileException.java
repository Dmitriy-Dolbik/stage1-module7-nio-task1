package com.epam.mjc.nio;

public class ReadingFileException extends RuntimeException
{
    public ReadingFileException(String message, Throwable cause){
        super(message, cause);
    }
    public ReadingFileException(String message){
        super(message);
    }
}
