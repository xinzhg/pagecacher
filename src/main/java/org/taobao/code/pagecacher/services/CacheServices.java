package org.taobao.code.pagecacher.services;

import org.taobao.code.pagecacher.common.dataobject.CacheKeyValueParams;
import org.taobao.code.pagecacher.common.dataobject.CacheResult;
import org.taobao.code.pagecacher.common.exception.CacheException;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zhang
 * Date: 13-8-23
 * Time: 下午5:48
 * To change this template use File | Settings | File Templates.
 */
public interface CacheServices {

    /**
     * default init method
     * @return
     * @throws CacheException
     */
    boolean init() throws CacheException;

    /**
     * customer's init method
     * @param initParamsMap
     * @return
     * @throws CacheException
     */
    boolean init(Map<String,String> initParamsMap) throws CacheException;

    /**
     * a put method , put a value to cachespaces
     * @param namespace
     * @param key
     * @param value
     * @param expirationTime
     * @return
     * @throws CacheException
     */
    boolean put(String namespace , String key , Serializable value , Integer expirationTime) throws CacheException;

    /**
     * a put method , use CacheKeyValueParams
     * @return
     * @throws CacheException
     */
    boolean put(CacheKeyValueParams cacheKeyValueParams) throws CacheException;

    /**
     * a multi put method
     * @param cacheKeyValueParamsList
     * @return
     * @throws CacheException
     */
    boolean mput(List<CacheKeyValueParams> cacheKeyValueParamsList) throws CacheException;

    /**
     * a get method
     * @param namespace
     * @param key
     * @return
     * @throws CacheException
     */
    CacheResult get(String namespace , String key) throws CacheException;

    /**
     * a multi get method
     * @param namespace
     * @param key
     * @return
     * @throws CacheException
     */
    List<CacheResult> mget(String namespace , List<String> key) throws CacheException;

    /**
     * a invaild cache method
     * @param namespace
     * @param key
     * @return
     * @throws CacheException
     */
    boolean invaild(String namespace , String key) throws CacheException;


}
