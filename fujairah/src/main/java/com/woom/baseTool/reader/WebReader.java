package com.woom.baseTool.reader;

import com.woom.baseTool.resource.Resource;

/**
 * Created by yuhao.zx on 14-9-14.
 */
public interface WebReader<T> {
    T read(Resource resource);
}
