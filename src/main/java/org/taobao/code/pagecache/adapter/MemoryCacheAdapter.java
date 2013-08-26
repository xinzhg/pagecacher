package org.taobao.code.pagecache.adapter;

import org.apache.commons.lang.StringUtils;
import org.taobao.code.pagecache.common.dataobject.CacheKeyValueParams;
import org.taobao.code.pagecache.common.dataobject.CacheResult;
import org.taobao.code.pagecache.common.exception.CacheException;
import org.taobao.code.pagecache.helper.MemoryCacheHelper;
import org.taobao.code.pagecache.services.CacheServices;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zhang
 * Date: 13-8-25
 * Time: 上午11:21
 * To change this template use File | Settings | File Templates.
 */
public class MemoryCacheAdapter implements CacheServices {

    private MemoryCacheHelper memoryCacheHelper;

    public MemoryCacheHelper getMemoryCacheHelper() {
        return memoryCacheHelper;
    }

    public void setMemoryCacheHelper(MemoryCacheHelper memoryCacheHelper) {
        this.memoryCacheHelper = memoryCacheHelper;
    }

    @Override
    public boolean init() throws CacheException {
        return memoryCacheHelper.init();
    }

    @Override
    public boolean init(Map<String, String> initParamsMap) throws CacheException {
        if(!StringUtils.isBlank(initParamsMap.get("initSize"))) {
            Integer size = Integer.parseInt(initParamsMap.get("initSize"));
            memoryCacheHelper.init(size);
        } else {
            memoryCacheHelper.init();
        }
           return true;
    }

    @Override
    public boolean put(String namespace, String key, Serializable value, Integer expirationTime) throws CacheException {
        CacheKeyValueParams cacheKeyValueParams = new CacheKeyValueParams();
        cacheKeyValueParams.setNameSpace(namespace);
        cacheKeyValueParams.setKey(key);
        cacheKeyValueParams.setValue(value);
        cacheKeyValueParams.setLastModifyTime(System.currentTimeMillis());
        cacheKeyValueParams.setExpirationTime(expirationTime*1000L);
        return memoryCacheHelper.put(cacheKeyValueParams);
    }

    @Override
    public boolean put(CacheKeyValueParams cacheKeyValueParams) throws CacheException {
        return memoryCacheHelper.put(cacheKeyValueParams);
    }

    @Override
    public boolean mput(List<CacheKeyValueParams> cacheKeyValueParamsList) throws CacheException {
        return memoryCacheHelper.mput(cacheKeyValueParamsList);
    }

    @Override
    public CacheResult get(String namespace, String key) throws CacheException {
        return coverCacheKeyValueParams2CacheResult(memoryCacheHelper.get(namespace , key));
    }

    @Override
    public List<CacheResult> mget(String namespace, List<String> keys) throws CacheException {
        List<CacheResult> list = null;
        for (String i : keys) {
            list.add(get(namespace , i));
        }
        return list;
    }

    @Override
    public boolean invaild(String namespace, String key) throws CacheException {
        CacheKeyValueParams cacheKeyValueParams = new CacheKeyValueParams();
        cacheKeyValueParams.setNameSpace(namespace);
        cacheKeyValueParams.setKey(key);
        cacheKeyValueParams.setValue(null);
        cacheKeyValueParams.setLastModifyTime(System.currentTimeMillis());
        cacheKeyValueParams.setExpirationTime(0L);
        return memoryCacheHelper.put(cacheKeyValueParams);
    }

    public CacheResult coverCacheKeyValueParams2CacheResult(CacheKeyValueParams cacheKeyValueParams) throws CacheException {
        CacheResult cacheResult = new CacheResult();
        cacheResult.setKey(cacheKeyValueParams.getNameSpace() + cacheKeyValueParams.getKey());
        cacheResult.setValue(cacheKeyValueParams.getValue());
        cacheResult.setLastModifyTime(cacheKeyValueParams.getLastModifyTime());
        cacheResult.setExpirationTime(cacheKeyValueParams.getExpirationTime());
        cacheResult.setSuccess(true);
        cacheResult.setErrorCode(-1);
        cacheResult.setErrorMessage("");
        return cacheResult;
    }

}
