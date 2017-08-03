package com.base.util.exception;

import java.text.MessageFormat;

/**
 * 内部通用异常
 * Created by houjun on 2017-1-10.
 */
public class CommonException extends RuntimeException {
    private static final long serialVersionUID = -5569636259861281518L;

    public CommonException() {
        super();
    }

    public CommonException(Throwable caught) {
        super(caught);
    }

    public CommonException(String pattern, Object... arguments) {
        super(MessageFormat.format(pattern, arguments));
    }

    public CommonException(Throwable caught, String pattern, Object... arguments) {
        super(MessageFormat.format(pattern, arguments), caught);
    }
}
