package com.base.util.exception;

import java.text.MessageFormat;

/**
 * Created by houjun on 2016-11-10.
 */
public class InspectionServiceException extends Exception{
    public InspectionServiceException() {
    }

    public InspectionServiceException(Throwable cause) {
        super(cause);
    }

    public InspectionServiceException(String message) {
        super(message);
    }

    public InspectionServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public InspectionServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public InspectionServiceException(String pattern, Object... arguments) {
        super(MessageFormat.format(pattern, arguments));
    }

    public InspectionServiceException(Throwable caught, String pattern,
                            Object... arguments) {
        super(MessageFormat.format(pattern, arguments), caught);
    }

}
