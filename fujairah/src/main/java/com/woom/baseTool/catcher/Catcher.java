package com.woom.baseTool.catcher;

import com.woom.baseTool.resource.Resource;

/**
 * Created by yuhao.zx on 14-9-11.
 */
public interface Catcher<T> {
    T catchContent(String url);
}
