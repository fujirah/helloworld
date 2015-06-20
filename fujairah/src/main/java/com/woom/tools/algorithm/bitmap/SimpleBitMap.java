package com.woom.tools.algorithm.bitmap;

import java.util.Scanner;

/**
 * Created by yuhao.zx on 15-6-12.
 */
public class SimpleBitMap {
    public static final int REAL_MAX = 10;
    public static final int SHIFT = 5;
    public static final int MASK = 0x1F;
    public static final int  BITSPERWORD = 32;
    public static int[] a = new int[1 + REAL_MAX / BITSPERWORD];
    public static void set(int i){
        a[i >> SHIFT] |= (1 << (i & MASK));
    }
    public static void clear(int i){
        a[i >> SHIFT] &= ~(1 << (i & MASK));
    }

    public static int test(int i){
        return a[i >> SHIFT] & (1 << (i & MASK));
    }

    public static void main(String[] args) {
        int i;
        for(i = 0;i<REAL_MAX;i++){
            clear(i);
        }
        Scanner s = new Scanner(System.in);
        int m;
        while( (m = s.nextInt()) != -1){
            set(m);
            System.out.println((m >> SHIFT) + " "+Integer.toBinaryString(a[m >> SHIFT]));
        }

        for(i = 0;i<REAL_MAX;i++){
            System.out.println(Integer.toBinaryString(test(i)));
            if(test(i) > 0){
                System.out.println("find="+i);
            }
        }
    }

}
