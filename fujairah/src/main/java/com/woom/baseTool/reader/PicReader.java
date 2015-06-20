package com.woom.baseTool.reader;

import com.woom.baseTool.resource.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yuhao.zx on 14-9-14.
 */
public class PicReader implements WebReader<Queue<byte[]>> {
    @Override
    public Queue<byte[]> read(Resource resource) {
        String location = resource.getLocation();
        InputStream is = null;
        Queue<byte[]> res = new LinkedList<byte[]>();
        try {
            URL url = new URL(location);
            is = url.openStream();
            byte[] result = new byte[1000];
            while(is.read(result) != -1){
                res.add(result);
                result = new byte[1000];
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null != is){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return res;
    }
}
