package com.woom.work;

/**
 * Created by yuhao.zx on 15-3-9.
 */
public class Basefee {
    public static void computer(Long refundFee,Long baseFee,Long nowExchangeFee,Long commissionFee){
        Long restExchangeFee = baseFee - nowExchangeFee - commissionFee + refundFee;
        if(restExchangeFee >= 0){
            System.out.println("exchangeCommFee "+commissionFee);
            System.out.println("commissionFee 0");
        }
        else{
            System.out.println("exchangeCommFee "+(baseFee-nowExchangeFee));
            System.out.println("commissionFee "+(-restExchangeFee));
        }
    }
}
