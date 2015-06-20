package com.woom.baseTool.resource;

import com.woom.baseTool.resource.Resource;

/**
 * Created by yuhao.zx on 14-9-11.
 */
public class HtmlResource implements Resource {
    public String location;
    public String getLocation() {
        return location;
    }

    public void setLocation(String s) {
        this.location = s;
    }
}
