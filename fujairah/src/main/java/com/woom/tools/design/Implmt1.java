package com.woom.tools.design;

/**
 * Created by yuhao.zx on 15-2-9.
 */
public class Implmt1 implements CommInter<Long,Long> {
    @Override
    public Long mNeedCount(Long param) {
        return 1L;
    }
}
