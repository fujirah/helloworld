package com.woom.spider;

import java.rmi.Remote;

/**
 * Created by yuhao.zx on 14-10-16.
 */
public interface RMIService extends Remote {
    public void invoke(MyRequest myRequest);
}
