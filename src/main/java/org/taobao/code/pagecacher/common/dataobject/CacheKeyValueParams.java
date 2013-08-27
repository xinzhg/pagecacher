package org.taobao.code.pagecacher.common.dataobject;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: zhang
 * Date: 13-8-24
 * Time: 下午1:57
 * To change this template use File | Settings | File Templates.
 */
public class CacheKeyValueParams implements Serializable {

    /**
     * cache namespace
     */
    public String nameSpace;

    /**
     * cache key
     */
    public String key;

    /**
     * need cache value
     */
    public Serializable value;

    /**
     * expiration time
     */
    public Long expirationTime;

    /**
     * cache last modify time
     */
    public Long lastModifyTime;

    public String getNameSpace() {
        return nameSpace;
    }

    public void setNameSpace(String nameSpace) {
        this.nameSpace = nameSpace;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Serializable getValue() {
        return value;
    }

    public void setValue(Serializable value) {
        this.value = value;
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
}
