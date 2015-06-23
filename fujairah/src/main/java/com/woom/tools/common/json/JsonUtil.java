package com.woom.tools.common.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuhao.zx on 2015/3/20.
 */
public class JsonUtil {
    public static final String map2Json(Map map){
        return JSONObject.toJSONString(map);
    }

    public static final String kV2Json(String key,Object value){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put(key,value);
        return map2Json(map);
    }
    /**
     * 根据key获取json字符串中的对象（该json串必须是map对象格式化的形式）获取二级
     * @param key
     * @param jsonStr
     * @param t
     * @param <T>
     * @return
     */
    public static final <T> T getObjectBykey(String key,String jsonStr,Class<T> t){
        if(null == jsonStr || null == key || t == null){
            return null;
        }
        HashMap<String,JSONObject> f = (HashMap<String,JSONObject>) JSON.parseObject(jsonStr, HashMap.class);
        if(null == f || null == f.get(key)){
            return null;
        }
        return JSONObject.toJavaObject(f.get(key),t);
    }

    /**
     * 根据key获取json字符串中的对象（该json串必须是map对象格式化的形式）获取一级数据
     * @param key
     * @param jsonStr
     * @param <T>
     * @return
     */
    public static final String getStringBykey(String key,String jsonStr){
        if(null == jsonStr || null == key){
            return null;
        }
        HashMap<String,String> f = (HashMap<String,String>) JSON.parseObject(jsonStr, HashMap.class);
        if(null == f || null == f.get(key)){
            return null;
        }
        return f.get(key);
    }


    /**
     * 将map转换成的json转换回map
     * @param jsonStr
     * @param t
     * @param <T>
     * @return
     */
    public static final <T> Map<String,T> json2Map(String jsonStr,Class<T> t){
        if(null == jsonStr || null == t){
            return null;
        }
        HashMap<String,JSONObject> f = (HashMap<String,JSONObject>) JSON.parseObject(jsonStr, HashMap.class);
        if(null == f || f.isEmpty()){
            return null;
        }

        Map<String,T> rs = new HashMap<String, T>();
        for(String key : f.keySet()){
            rs.put(key,JSONObject.toJavaObject(f.get(key),t));
        }
        return rs;
    }
}
