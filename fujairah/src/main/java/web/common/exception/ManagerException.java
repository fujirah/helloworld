package web.common.exception;

/**
 * Created by yuhao.zx on 14-9-21.
 */
public class ManagerException extends RuntimeException {

    public ManagerException(){
        super();
    }
    public ManagerException(Throwable e){
        super(e);
    }

    public ManagerException(String msg){
        super(msg);
    }

    public ManagerException(Throwable e,String msg){
        super(msg,e);
    }
}
