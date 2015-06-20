package com.woom.tools.guava;

import org.springframework.stereotype.Component;

/**
 * Created by yuhao.zx on 14-12-7.
 */
@Component
public class Tester {
    public void hello(){
        int a=0;
        for(int i=0;i<=10000;i++){
            a=(a+1);
        }
    }

}
