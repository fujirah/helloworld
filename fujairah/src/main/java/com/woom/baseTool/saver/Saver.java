package com.woom.baseTool.saver;

import java.io.*;
import java.util.Queue;

/**
 * Created by yuhao.zx on 14-9-14.
 */
public class Saver {
    public static String getPicName(String target){
        String[] rs = target.split("\\.");
        return String.valueOf((long)(Math.random()*10000000))+"."+rs[rs.length-1];
    }
    public static void savePic(String locate,Queue<byte[]> data){
        File file = new File(locate);
        FileOutputStream fos = null;
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            fos = new FileOutputStream(file);
            if(null == data)
                return;
            data.peek();
            while(data.peek()!=null){
                fos.write(data.remove());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
