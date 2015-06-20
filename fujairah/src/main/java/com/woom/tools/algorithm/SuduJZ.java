package com.woom.tools.algorithm;

import com.woom.tools.algorithm.Utils.DataUnit;
import com.woom.tools.algorithm.Utils.SuduUtils;

import java.util.*;

/**
 * Created by yuhao.zx on 2015/4/3.
 */
public class SuduJZ {
    static DataUnit[][] jz;
    static int count;
    public static String computer(String input){
        jz = new DataUnit[9][];
        count = SuduUtils.init(input, jz);
        SuduUtils.cacuCanAdd(jz);
        if(jz()){
            String rs = "";
            for(int i=0;i<9;i++){
                for(int j = 0;j<9;j++){
                    rs += String.valueOf(jz[i][j].data+",");
                }
            }
            jz = null;
            count = 0;
            return rs.substring(0,rs.length()-1);
        }else{
            jz = null;
            count = 0;
            return "fail";
        }
    }

    public static boolean jz(){
        if(count == 81){
            return true;
        }
        int temp = 9;
        int temx = -1;
        int temy = -1;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(!jz[i][j].isFix && jz[i][j].totalCanAdd > 0 && jz[i][j].data == 0){
                    if(temp > jz[i][j].totalCanAdd){
                        temp = jz[i][j].totalCanAdd;
                        temx = i;
                        temy = j;
                    }
                }
            }
        }

        if(temp == 9){
            return false;
        }

        DataUnit ele = jz[temx][temy];

        for(int i=1;i<=9;i++){
            if(ele.nowAdd.get(i) == null || !ele.nowAdd.get(i)){
                Set<Integer> te  = addEle(ele,i);
                if(jz()){
                    return true;
                }
                cancleEle(ele,i,te);
            }
        }
        return false;
    }
    private static Set<Integer> addEle(DataUnit ele,int value){
        ele.data = value;
        ele.nowAdd.put(value,true);
        count ++;
        ele.totalCanAdd --;
        return doAdd(ele.x,ele.y,jz,value);
    }

    private static void cancleEle(DataUnit ele,int value,Set<Integer> record){
        count --;
        ele.data = 0;
        ele.nowAdd.put(value, false);
        ele.totalCanAdd ++;
        if(record == null){
            return ;
        }
        for(Integer e : record){
            int y = e % 10;
            int x = e / 10;
            jz[x][y].totalCanAdd ++;
            jz[x][y].nowAdd.put(value,false);
        }

    }

    public static Set<Integer> doAdd(int x,int y,DataUnit[][] continer,int value){
        if(continer[x][y].isFix){
            return null;
        }
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<9;i++){
            if(i == y)
                continue;
            if(!continer[x][i].isFix && (continer[x][i].nowAdd.get(value) == null
                    || !continer[x][i].nowAdd.get(value))){
                continer[x][i].nowAdd.put(value,true);
                continer[x][i].totalCanAdd--;
                set.add(x*10 + i);
            }

        }

        for(int i=0;i<9;i++){
            if(i == x)
                continue;
            if(!continer[i][y].isFix && (continer[i][y].nowAdd.get(value) == null
                    || !continer[i][y].nowAdd.get(value))){
                continer[i][y].nowAdd.put(value,true);
                continer[i][y].totalCanAdd--;
                set.add(i*10 + y);
            }
        }

        for(int i=x - x%3 ;i < x - x%3 +3;i++){
            for(int j = y - y%3 ;j<y-y%3 +3;j++){
                if(i==x && j==y)
                    continue;
                if(!continer[i][j].isFix && (continer[i][j].nowAdd.get(value) ==null
                        || !continer[i][j].nowAdd.get(value))){
                    continer[i][j].nowAdd.put(value,true);
                    continer[i][j].totalCanAdd--;
                    set.add(i*10 + j);
                }

            }
        }
        return set;
    }
}
