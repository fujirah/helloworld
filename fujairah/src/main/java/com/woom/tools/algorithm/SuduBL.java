package com.woom.tools.algorithm;

import com.woom.tools.algorithm.Utils.DataUnit;
import com.woom.tools.algorithm.Utils.SuduUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuhao.zx on 2015/4/1.
 */
public class SuduBL {
    static DataUnit[][] dfs;

    public static String computer(String input){
        dfs = new DataUnit[9][];
        SuduUtils.init(input, dfs);

        if(tryPress(0,0)){
            String rs = "";
            for(int i=0;i<9;i++){
                for(int j = 0;j<9;j++){
                    rs += String.valueOf(dfs[i][j].data+",");
                }
            }
            dfs = null;
            return rs.substring(0,rs.length()-1);

        }else{
            dfs = null;
            return "fail";
        }
    }

    public static boolean tryPress(int x,int y){
        if(x == 9){
            return true;
        }

        if(dfs[x][y].isFix){
            int newX = (y+1)/9>0?x+1:x;
            int newY = y+1>=9?0:y+1;
            return tryPress(newX,newY);
        }

        Map<Integer,Boolean> canNot = getCanPut(x,y);
        for(int i=1;i<=9;i++){
            if(canNot.get(i)==null || !canNot.get(i)){
                dfs[x][y].data = i;
                int newX = (y+1)/9>0?x+1:x;
                int newY = y+1>=9?0:y+1;
                if(tryPress(newX,newY)){
                    return true;
                }
            }
        }
        dfs[x][y].data = 0;
        return false;
    }

    private static Map<Integer,Boolean> getCanPut(int x,int y){
        Map map = new HashMap();
        for(int i=0;i<9;i++){
            if(dfs[x][i].data > 0){
                map.put(dfs[x][i].data, true);
            }
        }

        for(int i=0;i<9;i++){
            if(dfs[i][y].data > 0){
                map.put(dfs[i][y].data, true);
            }
        }

        for(int i=x - x%3 ;i < x - x%3 +3;i++){
            for(int j = y - y%3 ;j<y-y%3 +3;j++){
                if(dfs[i][j].data > 0){
                    map.put(dfs[i][j].data, true);
                }
            }
        }
        return map;

    }
}
