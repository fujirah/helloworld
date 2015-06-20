package com.woom.baseTool.reader;

import com.woom.baseTool.resource.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by yuhao.zx on 14-9-14.
 */
public class HtmlReader implements WebReader<String> {

    public String read(Resource resource) {
        String location = resource.getLocation();
        StringBuffer target = new StringBuffer();
        InputStream is = null;
        BufferedReader br = null;
        try {
            URL url = new URL(location);
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));
            while(true){
                String line = br.readLine();
                if(line==null)
                    break;
                target.append(line);
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

            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return target.toString();
    }
}
