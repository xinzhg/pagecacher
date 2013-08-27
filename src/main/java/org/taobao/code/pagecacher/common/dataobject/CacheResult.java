package org.taobao.code.pagecacher.common.dataobject;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: zhang
 * Date: 13-8-24
 * Time: 下午1:44
 * To change this template use File | Settings | File Templates.
 */
public class CacheResult<T extends Serializable> {

    /**
     * cache value
     */
    public  T  value;

    /**
     * cache key
     */
    public Serializable key;

    /**
     *  need cache time
     */
    public Long expirationTime;

    /**
     * last modify time
     */
    public Long lastModifyTime;

    /**
     * error code
     * -1 means success
     */
    public Integer errorCode = -1;

    /**
     * error message
     */
    public String errorMessage;

    /**
     * check cache result if value exist
     * true means value exist
     * false means value not exist
     */
    public boolean isSuccess;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Serializable getKey() {
        return key;
    }

    public void setKey(Serializable key) {
        this.key = key;
    }

    public Long getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Long expirationTime) {
        this.expirationTime = expirationTime;
    }

    public Long getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Long lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
