package com.woom.tools.design;

/**
 * Created by yuhao.zx on 15-2-9.
 */
public class DesignTest {

    public static void main(String[] args) {
        int type = 1;
        CommInter t = Continer.continer.get(type);
        t.mNeedCount(1L);
    }
}
