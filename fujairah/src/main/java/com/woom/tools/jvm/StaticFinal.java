package com.woom.tools.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuhao.zx on 15-5-18.
 */
public class StaticFinal {
    public static void main(String[] args) {
        System.out.println(Angry.greeting);
        System.out.println(Dog.greeting);
        List<String> t = new ArrayList<String>();
        List<String> t1 = null;
        List<String> t2 = null;
        t.addAll(t1);
        t.addAll(t2);
    }
    static {
        System.out.println("staticFinal  was  init");
    }
}
interface Angry{
    String greeting = "GREE";
    int angerLevel = Dog.angerLever();
}

class Dog{
    static final  String greeting = "woof,woof,world!";
    static {
        System.out.println("dog is been  init");
    }
    static int angerLever(){
        System.out.println("Angery was init");
        return 1;
    }

}