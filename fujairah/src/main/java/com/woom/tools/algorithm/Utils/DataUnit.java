package com.woom.tools.algorithm.Utils;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuhao.zx on 2015/4/3.
 */
public class DataUnit {
    public int data;
    public boolean isFix = false;
    public int x;
    public int y;
    public Map<Integer,Boolean> nowAdd = new HashMap<Integer, Boolean>();
    public int totalCanAdd;
}
