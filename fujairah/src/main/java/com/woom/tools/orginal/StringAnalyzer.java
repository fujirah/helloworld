package com.woom.tools.orginal;

/**
 * Created by yuhao.zx on 14-12-16.
 */
public class StringAnalyzer {
    public static void main(String[] args) {
        testwy();
    }

    public static void testwy(){
        Integer a = 2;
        Integer b = 3;
        System.out.println(a.byteValue());
        System.out.println(b.byteValue());
        Integer c = a^b;
        System.out.println(c.byteValue());
        System.out.println(23123132>>>20);
    }
    public static void mapsHash(){
        int h =0;
        h^= "123".hashCode();

        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        h ^= (h >>> 20) ^ (h >>> 12);
        System.out.println(h ^ (h >>> 7) ^ (h >>> 4)) ;
    }
}
