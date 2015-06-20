package com.woom.tools.algorithm.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuhao.zx on 2015/4/3.
 */
public class SuduUtils {
    public static int init(String input ,DataUnit[][] continer){
        int count=0;
        String[] data = input.split(",");
        for(int i=0;i<9;i++){
            continer[i] = new DataUnit[9];
            for(int j = 0;j<9;j++){
                int ori = Integer.valueOf(data[i*9+j]);
                continer[i][j] = new DataUnit();
                if(ori != 0){
                    count ++;
                    continer[i][j].isFix = true;
                    continer[i][j].totalCanAdd = 0;
                }
                continer[i][j].data = ori;
                continer[i][j].x = i;
                continer[i][j].y = j;

            }
        }
        return count;
    }


    public static Map<Integer,Boolean> getCanPut(int x,int y,DataUnit[][] continer){
        Map map = new HashMap();
        if(continer[x][y].isFix){
            return  null;
        }
        for(int i=0;i<9;i++){
            if(continer[x][i].data > 0){
                map.put(continer[x][i].data, true);
            }
        }

        for(int i=0;i<9;i++){
            if(continer[i][y].data > 0){
                map.put(continer[i][y].data, true);
            }
        }

        for(int i=x - x%3 ;i < x - x%3 +3;i++){
            for(int j = y - y%3 ;j<y-y%3 +3;j++){
                if(continer[i][j].data > 0){
                    map.put(continer[i][j].data, true);
                }
            }
        }
        return map;

    }

    public static boolean canPut(int x,int y,DataUnit[][] continer,int value){
        for(int i=0;i<9;i++){
            if(continer[x][i].data == value){
                return false;
            }
        }

        for(int i=0;i<9;i++){
            if(continer[i][y].data == value){
                return false;
            }
        }

        for(int i=x - x%3 ;i < x - x%3 +3;i++){
            for(int j = y - y%3 ;j<y-y%3 +3;j++){
                if(continer[i][j].data == value){
                    return false;
                }
            }
        }
        return true;
    }
    public static void cacuCanAdd(DataUnit[][] continer){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                continer[i][j].nowAdd = getCanPut(i,j,continer);
                if(null != continer[i][j].nowAdd)
                    continer[i][j].totalCanAdd = 9 - continer[i][j].nowAdd.size();
            }
        }
    }
}
