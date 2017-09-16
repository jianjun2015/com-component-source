package org.seckill.exception;

/**
 * Created by wangjianjun on 2017/9/15.
 */
public class SeckillException extends RuntimeException{

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
