package com.woom.work;

/**
 * Created by yuhao.zx on 15-3-9.
 */
public class Topfee {
    public static void computer(Long refundFee,Long topFee,Long nowDeductFee,Long commissionFee){
        Long disTop =  topFee - nowDeductFee - commissionFee;
        if(disTop >= 0){
            System.out.println("FreeCommFee 0");
        }
        else{
            System.out.println("FreeCommFee "+(-disTop));
            System.out.println("commissionFee "+(topFee - nowDeductFee));
        }
    }
}
