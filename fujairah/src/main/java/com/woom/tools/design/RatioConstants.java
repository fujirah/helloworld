package com.woom.tools.design;

/**
 * Created by yuhao.zx on 15-2-9.
 */
public enum RatioConstants {
    M1(1,"第一种结算方式"),
    M2(2,"第二种结算方式");




    private Integer code;
    private String describtion;
    RatioConstants(Integer code,String describtion){
        this.code = code;
        this.describtion = describtion;
    }


    public Integer getCode() {
        return code;
    }
    public String getDescribtion() {
        return describtion;
    }
}
