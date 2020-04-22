package exception.examples;

import java.io.IOException;

public class SaveScoreException extends Exception
{
    public SaveScoreException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
