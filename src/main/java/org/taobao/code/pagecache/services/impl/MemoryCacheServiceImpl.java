package org.taobao.code.pagecache.services.impl;

import org.taobao.code.pagecache.adapter.MemoryCacheAdapter;
import org.taobao.code.pagecache.common.dataobject.CacheKeyValueParams;
import org.taobao.code.pagecache.common.dataobject.CacheResult;
import org.taobao.code.pagecache.common.exception.CacheException;
import org.taobao.code.pagecache.services.CacheServices;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zhang
 * Date: 13-8-24
 * Time: 下午4:48
 * To change this template use File | Settings | File Templates.
 */
public class MemoryCacheServiceImpl implements CacheServices {

    private MemoryCacheAdapter memoryCacheAdapter;

    public MemoryCacheAdapter getMemoryCacheAdapter() {
        return memoryCacheAdapter;
    }

    public void setMemoryCacheAdapter(MemoryCacheAdapter memoryCacheAdapter) {
        this.memoryCacheAdapter = memoryCacheAdapter;
    }

    @Override
    public boolean init() throws CacheException {
        return memoryCacheAdapter.init();
    }

    @Override
    public boolean init(Map<String, String> initParamsMap) throws CacheException {
        return memoryCacheAdapter.init(initParamsMap);
    }

    @Override
    public boolean put(String namespace, String key, Serializable value, Integer expirationTime) throws CacheException {
        return memoryCacheAdapter.put(namespace , key , value , expirationTime);
    }

    @Override
    public boolean put(CacheKeyValueParams cacheKeyValueParams) throws CacheException {
        return memoryCacheAdapter.put(cacheKeyValueParams);
    }

    @Override
    public boolean mput(List<CacheKeyValueParams> cacheKeyValueParamsList) throws CacheException {
        return memoryCacheAdapter.mput(cacheKeyValueParamsList);
    }

    @Override
    public CacheResult get(String namespace, String key) throws CacheException {
        return memoryCacheAdapter.get(namespace , key);
    }

    @Override
    public List<CacheResult> mget(String namespace, List<String> keys) throws CacheException {
        return memoryCacheAdapter.mget(namespace , keys);
    }

    @Override
    public boolean invaild(String namespace, String key) throws CacheException {
        return memoryCacheAdapter.invaild(namespace, key);
    }

}
