package com.woom.tools.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by yuhao.zx on 14-12-7.
 */
public class Context {
    public static ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:test/effective.xml");
    public static Object getBean(String name){
        return ac.getBean(name);
    }
}
