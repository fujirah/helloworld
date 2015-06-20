package com.woom.baseTool.catcher;

import com.woom.baseTool.reader.PicReader;
import com.woom.baseTool.reader.WebReader;
import com.woom.baseTool.resource.HtmlResource;
import com.woom.baseTool.resource.Resource;

import java.util.List;
import java.util.Queue;

/**
 * Created by yuhao.zx on 14-9-14.
 */
public class PicCatcher implements Catcher<Queue<byte[]>>{
    WebReader<Queue<byte[]>> webReader = new PicReader();
    private Resource resource = new HtmlResource();
    @Override
    public Queue<byte[]> catchContent(String url) {
        resource.setLocation(url);
        return webReader.read(resource);
    }
}
