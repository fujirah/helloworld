package com.woom.baseTool.catcher;

import com.woom.baseTool.reader.HtmlReader;
import com.woom.baseTool.reader.WebReader;
import com.woom.baseTool.resource.HtmlResource;
import com.woom.baseTool.resource.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by yuhao.zx on 14-9-11.
 */
public class HtmlCatcher implements Catcher<String> {
    private Resource resource = new HtmlResource();
    private WebReader<String> webReader = new HtmlReader();
    public String catchContent(String url) {
        resource.setLocation(url);
        String result =webReader.read(resource);
        return result;
    }
}
