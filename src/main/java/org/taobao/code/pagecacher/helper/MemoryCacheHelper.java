package org.taobao.code.pagecacher.helper;

import org.taobao.code.pagecacher.common.dataobject.CacheKeyValueParams;
import org.taobao.code.pagecacher.common.exception.CacheException;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 * User: zhang
 * Date: 13-8-25
 * Time: 上午10:59
 * To change this template use File | Settings | File Templates.
 */
public class MemoryCacheHelper {

    private ConcurrentHashMap<Serializable , CacheKeyValueParams> memoryCachePool = null;

    private static final Integer POOL_SIZE = 10000;

    public synchronized boolean init(Integer size) throws CacheException {
        if (this.memoryCachePool != null) {
            this.memoryCachePool = new ConcurrentHashMap<Serializable , CacheKeyValueParams>(size);
            return true;
        }
            return false;
    }

    public synchronized boolean init() throws CacheException {
        if (this.memoryCachePool != null) {
            this.memoryCachePool = new ConcurrentHashMap<Serializable, CacheKeyValueParams>(POOL_SIZE);
        }
            return false;
    }

    public boolean put(CacheKeyValueParams value) throws CacheException {
        memoryCachePool.put(value.getNameSpace() + "_" + value.getKey() , value);
        return true;
    }

    public boolean mput(List<CacheKeyValueParams> values) throws CacheException {
        for (CacheKeyValueParams i : values) {
            put(i);
        }
        return true;
    }

    public CacheKeyValueParams get(String namespace , String key) throws CacheException {
        CacheKeyValueParams cacheKeyValueParams = memoryCachePool.get(namespace + key);
        if (cacheKeyValueParams != null) {
            if (System.currentTimeMillis() - cacheKeyValueParams.getLastModifyTime() > cacheKeyValueParams.getExpirationTime()) {
                   return null;
            } else {
                return cacheKeyValueParams;
            }
        }
            return null;
    }

    public List<CacheKeyValueParams> mget(String namespace , List<String> keys) throws CacheException {
        List<CacheKeyValueParams> cacheKeyValueParamsesList = null;
        for (String i : keys) {
            CacheKeyValueParams cacheKeyValueParams = memoryCachePool.get(namespace + i);
            if (cacheKeyValueParams != null) {
                if (System.currentTimeMillis() - cacheKeyValueParams.getLastModifyTime() > cacheKeyValueParams.getExpirationTime()) {
                } else {
                    cacheKeyValueParamsesList.add(cacheKeyValueParams);
                }
            }
            return cacheKeyValueParamsesList;
        }
        return cacheKeyValueParamsesList;
    }

    public boolean invaild(String namespace , String key) throws CacheException {
        Object object = memoryCachePool.remove(namespace + key);
        if (object != null) {
            return true;
        } else {
            return false;
        }
    }

}
