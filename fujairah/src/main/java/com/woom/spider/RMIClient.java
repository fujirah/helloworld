package com.woom.spider;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by yuhao.zx on 14-10-16.
 */
public class RMIClient {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        String url="rmi://localhost/Hello";
        RMIService rmiService;
        rmiService = (RMIService) Naming.lookup(url);
        MyRequest mr = new MyRequest();
        mr.a = 1;
        System.out.println("a = "+mr.a);
        rmiService.invoke(mr);
        System.out.println("a = "+mr.a);
    }
}
