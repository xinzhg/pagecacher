package org.taobao.code.pagecacher.common.exception;

/**
 * Created with IntelliJ IDEA.
 * User: zhang
 * Date: 13-8-23
 * Time: 下午5:49
 * To change this template use File | Settings | File Templates.
 */
public class CacheException extends Exception {
     public CacheException() {
         super();
     }

    public CacheException(String message) {
        super(message);
    }

    public CacheException(String message, Throwable cause) {
        super(message, cause);
    }

    public CacheException(Throwable cause) {
        super(cause);
    }

}
