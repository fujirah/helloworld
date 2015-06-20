package com.woom.tools.orginal.thread;

/**
 * Created by yuhao.zx on 15-1-20.
 */
public class Entity {
    public int t;
    public Entity(int t){
        this.t = t;
    }
    public int hashCode(){
        return t % 10 + 998372;
    }
}
