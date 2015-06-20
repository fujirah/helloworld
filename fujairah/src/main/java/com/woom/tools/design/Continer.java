package com.woom.tools.design;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yuhao.zx on 15-2-9.
 */
public class Continer {
    public static Map<Integer,CommInter> continer = new ConcurrentHashMap<Integer, CommInter>();
    static {
        continer.put(RatioConstants.M1.getCode(),new Implmt1());
        continer.put(RatioConstants.M2.getCode(),new Implmt2());
    }
}
